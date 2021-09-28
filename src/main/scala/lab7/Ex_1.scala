package lab7
import chisel3._
import chisel3.util._

class Ex_1 extends Module {           // priority arbiter
    val io = IO ( new Bundle {
        val in = Flipped(Decoupled(UInt(8.W))) 
        val in2 = Flipped(Decoupled(UInt(8.W)))
        val consumer = Decoupled(UInt(8.W ))
        })


    val producer_q1 = Queue(io.in)
    val producer_q2 = Queue(io.in2)
    val arb = Module(new Arbiter(UInt(), 2))

    arb.io.in(0) <> producer_q2
    arb.io.in(1) <> producer_q1

    io.consumer <> arb.io.out
}

// class Ex_1 extends Module {           // RR arbiter
//     val io = IO ( new Bundle {
//         val in = Flipped(Decoupled(UInt(8.W))) 
//         val in2 = Flipped(Decoupled(UInt(8.W)))
//         val in3 = Flipped(Decoupled(UInt(8.W)))
//         val consumer = Decoupled(UInt(8.W ))
//         })


//     val producer_q1 = Queue(io.in)
//     val producer_q2 = Queue(io.in2)
//     val producer_q3 = Queue(io.in3)
//     val arb = Module(new RRArbiter(UInt(), 3))

//     arb.io.in(0) <> producer_q1
//     arb.io.in(1) <> producer_q2
//     arb.io.in(2) <> producer_q3

//     io.consumer <> arb.io.out
// }

