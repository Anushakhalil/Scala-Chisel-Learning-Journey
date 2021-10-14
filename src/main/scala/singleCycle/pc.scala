package singleCycle
import chisel3._

class pc extends Module with Config {
	val io = IO(new Bundle{
		val input = Input(SInt(WLEN.W))
		val output = Output(SInt(WLEN.W))
		val pc_4 = Output(SInt(WLEN.W))
	})
    
	val reg= RegInit(0.S(WLEN.W))
	reg := io.input
	io.output := reg
	io.pc_4 := reg + 4.S
}