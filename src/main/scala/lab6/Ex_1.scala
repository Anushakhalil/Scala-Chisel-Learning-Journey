package lab6
import chisel3._

class Ex_1( val init : Int = 1) extends Module {
    val io = IO ( new Bundle {
        val in = Input(UInt(4.W))
        val reload = Input(Bool())
        val out = Output(UInt(4.W))
})
    val state = RegInit(init.U(4.W))
    
    when(io.reload){
        val nextState = (state << 1 ) | 0.U
        state := nextState
        io.out := state
    }.otherwise{
        io.out := io.in
    }
}