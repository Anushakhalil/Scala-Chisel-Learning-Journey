package lab6
import chisel3._

class Ex_3 extends Module{
    val io = IO (new Bundle{
        val reload = Input(Bool())
        val out = Output(Bool())
    })

    val timer_count = RegInit(0.U(8.W))
    val next = WireInit(6.U)
    
    io.out := 0.U

    when(io.reload){
        when(timer_count =/= 0.U){
            next := timer_count - 1.U
        }.otherwise{
            io.out := 1.B
            timer_count := next
        }
    }otherwise{
        DontCare
    }
}