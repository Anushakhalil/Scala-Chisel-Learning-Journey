package singleCycle
import chisel3._
import chisel3.util._

class Topfile extends Module with Config {
    val io = IO(new Bundle{
        val final_out = Output(SInt(WLEN.W)) 

    })
// objects of modules 
    val alu = Module(new ALU())
    val alucontrol = Module(new AluControl())
    val branchalu = Module(new branchAlu())
    val control = Module(new control())
    val immgen = Module(new ImmGen())
    val insmem = Module(new InsMem("/home/anusha/Scala-Chisel-Learning-Journey/src/main/scala/lab8/file.txt"))
    val mainmem = Module(new mainMem(new Parameters(32,10)))
    val Pc = Module(new pc())
    val regfile = Module(new RegisterFile())
    val writeback = Module(new writeBackModule())

    // Imm
    insmem.io.addr := Pc.io.output(11,2).asUInt 

    // Pc 
    // Pc.io.input := Pc.io.pc_4

    // control 
    control.io.Opcode := insmem.io.inst(6,0) // opcode

    // immgen 
    immgen.io.instr := insmem.io.inst // Imm
    immgen.io.mux_sel := control.io.Imm_sel

    // mux 1 of reg file 
    val mux1_out = MuxCase(0.S , Array(
        (control.io.OperA_sel === 0.U) -> regfile.io.rdata1,
        (control.io.OperA_sel === 1.U) -> Pc.io.output,
        (control.io.OperA_sel === 2.U) -> Pc.io.pc_4,
        (control.io.OperA_sel === 3.U) -> regfile.io.rdata1,
    ))

    // mux 2 of reg file 
    val mux2_out = MuxCase(0.S , Array(
        (control.io.OperB_sel === 0.B) -> regfile.io.rdata2,
        (control.io.OperB_sel === 1.B) -> immgen.io.immd_se,
    ))
    
    // Alu control
    alucontrol.io.opcFromControl := control.io.AluOp
    alucontrol.io.func3inAC := insmem.io.inst(14,12)
    alucontrol.io.func7inAC := insmem.io.inst(30)

    // Alu 
    alu.io.sel := alucontrol.io.aluControl
    alu.io.b := mux2_out
    alu.io.a := mux1_out

    //  main memory 
    mainmem.io.read := control.io.MemRead
    mainmem.io.wr_en := control.io.MemWrite
    mainmem.io.data_in := regfile.io.rdata2
    mainmem.io.addr := alu.io.out(11,2).asUInt

    // write back module
    writeback.io.sel_mux1 := control.io.MemToReg
    writeback.io.sel_mux2 := control.io.Jalr_pin
    writeback.io.in0_mux1 := alu.io.out
    writeback.io.in1_mux1 := mainmem.io.data_out
    writeback.io.in1_mux2 := Pc.io.pc_4

    // Regfile
    regfile.io.raddr1 := insmem.io.inst(19,15) // rs1
    regfile.io.raddr2 := insmem.io.inst(24,20) // rs2
    regfile.io.waddr := insmem.io.inst(11,7) // rd selc
    regfile.io.wdata := writeback.io.writeBackValue
    regfile.io.wen := control.io.RegFile

    // branch ALu 
    branchalu.io.arg_x := regfile.io.rdata1
    branchalu.io.arg_y := regfile.io.rdata2
    branchalu.io.func3 := insmem.io.inst(14,12)
    control.io.Bnew := branchalu.io.br_taken

    // nex pc sel mux
    val b_and_pc = immgen.io.B + Pc.io.output
    val j_and_pc = immgen.io.J + Pc.io.output

    val out = MuxCase(0.S, Array(
        (control.io.NextPc_sel === 0.U) -> Pc.io.pc_4,
        (control.io.NextPc_sel === 1.U) -> b_and_pc,
        (control.io.NextPc_sel === 2.U) -> j_and_pc,
        (control.io.NextPc_sel === 3.U) -> alu.io.out
    ))

    Pc.io.input := out
    io.final_out := regfile.io.waddr.asSInt

}