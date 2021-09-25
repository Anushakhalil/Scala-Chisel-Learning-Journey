package lab6
import chisel3._
import chisel3.util._

class twoQueue extends Module{
    val io = IO(new Bundle{
        val in1 = Flipped(Decoupled(UInt(8.W )))
        val out1 = Decoupled(UInt(8.W ))
    })

    io.out1 <> io.in1
        
}

// class Ex_4 extends Module {
//     val io = IO ( new Bundle {
//         val in = Flipped(Decoupled(UInt(8.W))) 
//         // valid = Input , ready = Output , bits = Input

//         val out = Decoupled(UInt(8.W ))
//         // valid = Output , ready = Input , bits = Output
//         })

//     io.out.bits := 0.U
//     io.out.valid := 1.B
//     io.in.ready := 1.B

    // val q = Module(new twoQueue) // queue1
//     // val q2 = Module(new twoQueue) // queue2

//     when(io.in.ready & io.out.valid)
//     { 
        // q.io.in1 <> io.in
        // io.out <> io.in
//     }.otherwise{

//         io.out.bits := 0.U
//         io.out.valid := 1.B
//         io.in.ready := 1.B
//     }
// }
class Ex_4 extends Module {
    val io = IO ( new Bundle {
        val in = Flipped(Decoupled(UInt(8.W))) 
        // valid = Input , ready = Output , bits = Input

        val out = Decoupled(UInt(8.W ))
        // valid = Output , ready = Input , bits = Output
        })


    io.out.bits := 0.U
    io.out.valid := 1.B
    io.in.ready := 1.B

    // 5 - element queue
    val q = Module(new twoQueue) // queue1

    when( io.in.valid & io.out.ready )
    { 
    when (
        q.io.in1.valid & q.io.out1.ready
    ){
        q.io.in1 <> io.in
        io.out <> q.io.out1
    }
    
    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 1.B
        io.in.ready := 1.B
    }
}