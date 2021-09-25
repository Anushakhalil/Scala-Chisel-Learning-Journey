package lab6

import chisel3._
import chisel3.util._
// import chisel3. iotesters .{
// ChiselFlatSpec , Driver , PeekPokeTester
// }

class Pipe extends Module {
val io = IO ( new Bundle {
val in = Flipped(Valid(UInt(8.W)))
val out = Valid(UInt(8.W))
})

// io.out.bits := io.in.bits
// io.out.valid := io.in.valid
 // ---- OR -----

io.out <> io.in

// io.out := new pipeAndQueue(io.in ,5)
}