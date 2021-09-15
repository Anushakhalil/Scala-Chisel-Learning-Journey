package example
import chisel3._

class fourBitAdder extends Module{
  val io = IO(new Bundle{
    val a0 = Input(UInt(1.W))
    val a1 = Input(UInt(1.W))
    val a2 = Input(UInt(1.W))
    val a3 = Input(UInt(1.W))
    val b0 = Input(UInt(1.W))
    val b1 = Input(UInt(1.W))
    val b2 = Input(UInt(1.W))
    val b3 = Input(UInt(1.W))
    val c_out0 = Output(UInt(1.W))
    val c_out1 = Output(UInt(1.W))
    val sum0 = Output(UInt(1.W))
    val sum1 = Output(UInt(1.W))
    val c_out2 = Output(UInt(1.W))
    val c_out3 = Output(UInt(1.W))
    val sum2 = Output(UInt(1.W))
    val sum3 = Output(UInt(1.W))
  })
  io.sum0 := io.a0 ^ io.b0
  io.c_out0 := io.a0 & io.b0
  io.sum1 := io.a1 ^ io.b1
  io.c_out1 := io.a1 & io.b1
  io.sum2 := io.a2 ^ io.b2
  io.c_out2 := io.a2 & io.b2
  io.sum3 := io.a3 ^ io.b3
  io.c_out3 := io.a3 & io.b3
}
