// package lab6
// import chisel3._

// class Ex_3(val din: UInt = 1.U) extends Module{
//     val io = IO(new Bundle{
//         val reload = Input(Bool())
//         val timer_count = RegInit(0.U(8.W))
//         val done = timer_count === 0.U
//         val next = WireInit(0.U)
//     })

//     when(io.reload){
//     io.next := din

//     }.elsewhen(!io.done ) {
//     io.next := io.timer_count - 1.U

//     }.otherwise{
//         io.timer_count := io.next
//     }
// }