package lab6
import chisel3._

class Ex_3 extends Module{
    val io = IO (new Bundle{
        val reload = Input(Bool())
        val out = Output(Bool())
    })
    val din = 6.U
    val timer_count = RegInit(0.U(8.W))
    val next = WireInit(0.U)
    val done = timer_count =/= 0.U 

    // io.out := 0.B
    // when(io.reload){
    //    next := din
       
    //    when(done){
    //         next := timer_count - 1.U
    //         timer_count := timer_count - 1.U
    //         io.out := 0.B

    //     }.otherwise{
    //         timer_count := next
    //         io.out := 1.B
    //     }

    // }.otherwise{
    //     DontCare
    // }

}