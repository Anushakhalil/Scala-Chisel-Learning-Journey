package lab6
import chisel3._

class Task3( val len : Int = 3) extends Module {
    val io = IO ( new Bundle {

        val out = Vec(len , Output(Bool()))  
        val load_in = Vec(len , Input(Bool()))
        val in = Input(Bool())
        val load = Input(Bool())

})
    val state = RegInit(1.U(len.W))

    for (i <- 0 until len){

        when(io.load){
            val nextState = (state << 1 ) | io.in
            state := nextState
            io.out(i) := state(i).asBool

        }.otherwise{
            io.out(i) := io.load_in(i)
        }
    }
}