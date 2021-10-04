package lab6
import chisel3._

class Task3( val len : Int = 3) extends Module {
    val io = IO ( new Bundle {

        val out = Vec(len , Output(Bool()))  
        val load_in = Vec(len , Input(Bool()))
        val in = Input(Bool())
        val load = Input(Bool())

})
    io.out(0) := 0.B
    io.out(1) := 0.B
    io.out(2) := 0.B

    val state = RegInit(0.U(len.W))
    val count = RegInit(0.U(2.W))

    when(count =/= 3.U){
        when(io.load){
            val nextState = (state << 1 ) | io.in
            state := nextState
            io.out(count) := state(count).asBool
            count := count + 1.U

        }.otherwise{
            state := io.load_in(count).asUInt
        }
        
    }

}