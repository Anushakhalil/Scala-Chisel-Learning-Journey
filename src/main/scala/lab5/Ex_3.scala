package lab5
import chisel3._

// op is a reduce function: combines elements of array to generate a single value
 // based on th op defined
class Ex_3 [T <: Data](n : Int, generic: T) (op: (T, T) => T) 
extends Module{

    require(n > 0)
    val io = IO(new Bundle{
        val in = Input(Vec(n, generic))
        val out = Output(Vec(n, generic))
    })
    
     io.out(0) := io.in.reduce(op)
     io.out(1) := io.in.reduce(op)
     io.out(2) := io.in.reduce(op)
     }