package example
import chisel3._

class adder extends Module{
  val io = IO(new Bundle{
    val a= Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val c_out = Output(UInt(1.W))
    val sum = Output(UInt(1.W))
  })

  io.sum := io.a ^ io.b
  io.c_out := io.a & io.b
}