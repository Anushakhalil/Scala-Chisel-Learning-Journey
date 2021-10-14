package singleCycle
import chisel3._

trait Config{
    val WLEN= 32
    val TYPE = UInt

    val ALUOP_SIG_LEN = 4
    val FUNC_3 = 3
    val OPCODE = 7

	val PIN_ALU_OP = 3
	val TWO_BIT_SEL = 2
    val INST_MEM_LEN = 1024
    val REGFILE_LEN = 32 
}