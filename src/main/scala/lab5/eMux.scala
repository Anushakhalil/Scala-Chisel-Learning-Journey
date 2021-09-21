package lab5
import chisel3._
import chisel3.util._

class eMux[T <: Data](gen: T) extends Module {
    val io = IO(new Bundle{
        val out = Output(gen)  
        val in1 = Input(gen)  // true condition
        val in2 = Input(gen)  // sel
        val sel = Input(Bool()) // false condition
    })
    io.out := Mux2_to_1(io.in2, io.in1, io.sel) // 2,1,1

    def Mux2_to_1[T <: Data](in_0 : T, in_1 : T, sel : Bool): T = {  // 2,1,1
        Mux(sel, in_1, in_0)
    }
}