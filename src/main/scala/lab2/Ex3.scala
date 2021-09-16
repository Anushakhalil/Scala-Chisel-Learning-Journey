package lab2
import chisel3._
import chisel3.util._

class Ex3 extends Module {
  val io = IO( new Bundle {
    val In = Input(UInt(4.W))
    val Out = Output(UInt(2.W))
  })
  io.Out := Mux1H(io.In , Seq(0.U, 1.U, 2.U, 3.U))
}