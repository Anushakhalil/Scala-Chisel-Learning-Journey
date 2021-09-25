package lab6
import chisel3._
import chisel3.util._

class Queue extends Module {
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
    when(io.in.valid & io.out.ready)
    { 
        io.out <> io.in
        
    }.otherwise{
        io.out.bits := 0.U
        io.out.valid := 1.B
        io.in.ready := 1.B
    }
}