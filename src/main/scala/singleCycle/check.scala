package singleCycle
import chisel3._
import  chisel3.util._

class check extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(32.W))
    val b = Input(UInt(32.W))
    val out = Output(UInt(32.W))
  })
  val zeroToFour = io.b(4, 0)
  io.out := io.a >> zeroToFour
}