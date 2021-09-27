package lab6
import chisel3._
import chisel3.util._

class Ex_4 extends Module {
    val io = IO ( new Bundle {
        val in = Flipped(Decoupled(UInt(8.W))) 
        // valid = Input , ready = Output , bits = Input

        val out = Decoupled(UInt(8.W ))
        // valid = Output , ready = Input , bits = Output
        })
    
    io.out.valid := 1.B
    io.in.ready := 1.B
    
    val q = Queue(io.in, 8)
    val q2 = Queue(q, 8)

    when( io.in.valid & q.ready ){
        when(q.valid & q2.ready ){
            when(q2.valid & io.out.ready ){
                
                io.out.enq(q2.deq())

            }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
            }

        }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
        }

    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 0.B
    }
}