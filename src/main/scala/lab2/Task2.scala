package lab2
import chisel3._
import chisel3.util._


class Task2 extends Module {
  val io = IO ( new Bundle {
    val in = Vec (4 ,Input (Bool () ) )
    val sel = Vec (2 ,Input (Bool () ) )
    val shift_type = Input (Bool())
    val out = Vec (4 ,Output(Bool () ) )
  })
  // Start you code here
  val Sel = Cat(io.sel(1), io.sel(0)).asUInt()

io.out(0) =: MuxCase(false.B, Array(
  Sel === "b00".U -> io.in(0),
  Sel === "b01".U -> io.in(1),
  Sel === "b10".U -> io.in(2),
  Sel === "b11".U -> io.in(3)
))

io.out(1) := MuxCase(false.B, Array(
  Sel === "b00".U -> io.in(1),
  Sel === "b01".U -> io.in(2),
  Sel === "b10".U -> io.in(3),
  Sel === "b11".U -> Mux(io.shift_type , 0.U, io.in(0)),
))

io.out(2) := MuxCase(false.B, Array(
  Sel === "b00".U -> io.in(2),
  Sel === "b01".U -> io.in(3),
  Sel === "b10".U -> Mux(io.shift_type ,0.U, io.in(0)),
  Sel === "b11".U -> Mux(io.shift_type ,0.U, io.in(1))
))

io.out(3) := MuxCase(false.B, Array(
  Sel === "b00".U -> io.in(3),
  Sel === "b01".U -> Mux(io.shift_type, 0.U, io.in(0)),
  Sel === "b10".U -> Mux(io.shift_type ,0.U, io.in(1)),
  Sel === "b11".U -> Mux(io.shift_type, 0.U ,io.in(2))
))
  // End your code here
}