package lab5
import chisel3._
import chisel3.util._

class IOsome [T <: Data](data_type : T) extends Bundle{
    val ina = Input(data_type.cloneType)
    val inb = Input(data_type.cloneType)
    val out = Output(data_type.cloneType)
    val sel = Input(Bool())
}

class Adder(size: UInt) extends Module{
    val io = IO(new IOsome(size))

    when(io.sel){
    io.out := io.ina + io.inb
    }.otherwise {
        io.out := 0.U
    }

}