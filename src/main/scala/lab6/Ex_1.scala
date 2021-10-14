package lab6
import chisel3._
import chisel3.util._

class Ex_1( val init : Int = 0) extends Module {
    val io = IO ( new Bundle {
        val in = Input(UInt(3.W))
        val reload = Input(Bool())
        val out = Output(Bool())
})
    val state = RegInit(init.U(3.W))
    
    io.out := 0.U
    when(io.reload===0.U){
        state := io.in 

    }.otherwise{
        val nextState = (state >> 1)
        state := nextState
    }

    io.out := state
}