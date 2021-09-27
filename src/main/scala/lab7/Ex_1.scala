package lab7
import chisel3._
import chisel3.util._

class Queue extends Module {
    val io = IO ( new Bundle {
        val in = Flipped(Decoupled(UInt(8.W))) 
        val consumer = Decoupled(UInt(8.W ))
        })

    val producer_q1 = Queue(io.in,8)
    val producer_q2 = Queue(io.in,8)

    val arb = Module(new Arbiter(UInt(), 2))
    arb.io.in(0) <> producer_q1.deq()
    arb.io.in(1) <> producer_q2.deq()

    io.consumer <> arb.io.out
}