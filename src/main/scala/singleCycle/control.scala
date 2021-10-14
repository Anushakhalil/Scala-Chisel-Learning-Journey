package singleCycle
import chisel3._
import chisel3.util._
import scala.collection._


class control extends Module with Config{
	val io= IO(new Bundle{
		val Opcode= Input(TYPE(OPCODE.W))
        val Bnew = Input(Bool())
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

	val tD= Module(new typeDecode())
	val cD= Module(new controlDecode())
	
	tD.io.Opcode := io.Opcode

    val typeDecode_out = List(tD.io.Rtype,tD.io.Itype,tD.io.Branch,tD.io.Load,
                            tD.io.Store,tD.io.Jal,tD.io.Jalr,tD.io.Lui,tD.io.Auipc)

    val controlDecode_in = List(cD.io.Rformat,cD.io.Itype,cD.io.Branch,cD.io.Load,
                            cD.io.Store,cD.io.Jal,cD.io.Jalr,cD.io.Lui,cD.io.Auipc)

    val controlDecode_out = List(cD.io.MemWrite,cD.io.AluOp,cD.io.MemRead,cD.io.RegFile,
                            cD.io.MemToReg,cD.io.OperB_sel,cD.io.Jalr_pin,cD.io.OperA_sel,
                            cD.io.Imm_sel,cD.io.NextPc_sel,cD.io.AluOper)

    val out = List(io.MemWrite,io.AluOp,io.MemRead,io.RegFile,
                    io.MemToReg,io.OperB_sel,io.Jalr_pin,io.OperA_sel,
                    io.Imm_sel,io.NextPc_sel,io.AluOper)

    cD.io.Bnew := io.Bnew
    val zipped = controlDecode_in.zip(typeDecode_out)
    zipped.map{x=> x._1:=x._2}
    val zipped2 = out.zip(controlDecode_out)
    zipped2.map{x=> x._1:=x._2}
    

}	