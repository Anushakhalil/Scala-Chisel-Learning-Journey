package lab2
import chisel3._
import chisel3.util._

class Ex2 extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(8.W)) // b10110010
    val sel0 = Input(Bool()) // false
    val sel1 = Input(Bool()) // true
    val sel2 = Input(Bool()) // false
    val out = Output(Bool()) // true

  })
  val Mux4_to_1_a = MuxLookup(io.sel1, false.B, Array(
    0.U -> MuxLookup(io.sel0, false.B, Array(
      (0.U) -> io.in(0),
      (1.U) -> io.in(1)
  )),
    1.U -> MuxLookup(io.sel0, false.B, Array(
      (0.U) -> io.in(2),
      (1.U) -> io.in(3)
    ))
  ))
  val Mux4_to_1_b = MuxLookup(io.sel1, false.B, Array(
    (0.U) -> MuxLookup(io.sel0, false.B, Array(
      (0.U) -> io.in(4),
      (1.U) -> io.in(5)
  )),
    (1.U) -> MuxLookup(io.sel0, false.B, Array(
      (0.U) -> io.in(6),
      (1.U) -> io.in(7)
    ))
  ))
  val Mux2_to_1 = MuxLookup(io.sel2, false.B, Array(
    (0.U) -> Mux4_to_1_b,
    (1.U) -> Mux4_to_1_a)
  )
  // Connecting output of 2 _to_1 Mux with the output port .
  io.out := Mux2_to_1
}