package lab5
import chisel3._
import chisel3.util._


class Emux[T <: Data](data_type: T) extends Bundle {
    val out = Output(data_type.cloneType)  
    val in1 = Input(data_type.cloneType)
    val in2 = Input(data_type.cloneType) 
    val sel = Input(Bool()) 
}

class Ex_2(size : UInt) extends Module{
    val io = IO(new Emux(size))

    io.out := Mux(io.sel, io.in2, io.in1)
}