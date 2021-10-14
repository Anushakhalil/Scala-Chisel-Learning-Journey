package singleCycle
import chisel3._
import chisel3.util._
import scala.collection._


class controlDecode extends Module with Config{
	val io= IO(new Bundle{

		val Rformat= Input(Bool())
		val Load= Input(Bool())
		val Store= Input(Bool())
		val Branch= Input(Bool())
        val Bnew = Input(Bool())
		val Itype= Input(Bool()) 
		val Jalr = Input(Bool())
		val Jal = Input(Bool())
		val Lui = Input(Bool())
        val Auipc = Input(Bool())

		val MemWrite = Output(Bool())
		val AluOp = Output(TYPE(PIN_ALU_OP.W))
		val MemRead = Output(Bool())
		val RegFile = Output(Bool())
		val MemToReg = Output(Bool())
		val AluOper = Output(Bool())
		val OperA_sel = Output(TYPE(TWO_BIT_SEL.W))
		val OperB_sel = Output(Bool())
		val Imm_sel = Output(TYPE(TWO_BIT_SEL.W))
		val NextPc_sel = Output(TYPE(TWO_BIT_SEL.W))
        val Jalr_pin = Output(Bool())
	})

	val inputs = List(io.Rformat,io.Load,io.Store,
                io.Itype,io.Jalr,io.Jal,io.Lui,io.Auipc)

    val outputs = List(io.MemWrite,io.MemRead,io.RegFile,
                  io.MemToReg,io.OperB_sel,io.Jalr_pin,io.AluOper)

    val outputs_U = List(io.OperA_sel,io.Imm_sel,io.NextPc_sel,io.AluOp)

    outputs_U.map(_ := 0.U)
    outputs.map(_ := 0.B)

    // for operand a sel
    val op_or1 = inputs(6) | inputs(7) 
    val op_or2 = inputs(6) | inputs(5)
    io.OperA_sel := Cat(op_or2,op_or1)  

    // for imm sel
    val immor1 = inputs(0) | inputs(2) | inputs(5) | io.Branch & io.Bnew
    val immor2 = inputs(0) | inputs(5) | io.Auipc | io.Lui | io.Branch & io.Bnew
    io.Imm_sel := Cat(immor2,immor1)

    // for next pc sel
    val next_or1 = inputs(4) | io.Branch & io.Bnew
    val next_or2 = inputs(4) | inputs(5)
    io.NextPc_sel := Cat(next_or2 , next_or1)

    // for Alu op sel
    val and1 = !inputs(0) & !inputs(1) & !inputs(3) & !inputs(4) & !inputs(5)
    val and2 = !inputs(0) & !inputs(1) & !inputs(2) & !io.Auipc
    val and3 = !inputs(0) & !inputs(2) & !inputs(3) & !io.Lui
    io.AluOp := Cat(and1,and2,and3)

    // for other pins 
    var lst = scala.collection.mutable.Map[Bool , List[Bool]]()

    lst += (inputs(0) -> List(outputs(2)))
    lst += (inputs(1) -> List(outputs(2),outputs(4),outputs(3), outputs(1)))
    lst += (inputs(2) -> List(outputs(0),outputs(4)))
    lst += (inputs(3) -> List(outputs(2),outputs(4)))
    lst += (inputs(4) -> List(outputs(2),outputs(4),outputs(5)))
    lst += (inputs(5) -> List(outputs(2)))
    lst += (inputs(6) -> List(outputs(2),outputs(4)))
    lst += (inputs(7) -> List(outputs(2),outputs(4)))
    
    inputs.map(x => when(x === 1.B){ lst(x).map(_ := 1.B) })

}