package singleCycle
import chisel3._
import  chisel3.util._

class ALU extends Module with Config{
    val io = IO(new Bundle{
    val a = Input(SInt(32.W))
    val b = Input(SInt(32.W))
    val sel = Input(TYPE(4.W))
    val out = Output(SInt(32.W))
  })
  
  val zeroToFour = io.b(4,0)
  val adder = io.a + io.b
  val sub = io.a - io.b
  val and = io.a & io.b
  val or = io.a | io.b
  val xor = io.a ^ io.b
  val srl = (io.a).asUInt >> zeroToFour.asUInt   // 4 bits right shift
  val sra = (io.a) >> zeroToFour
  val sll = (io.a(4,0)) << zeroToFour.asUInt
  val slt = Mux((io.a < io.b), 1.S, 0.S)
  val sltu = Mux(((io.a).asUInt < (io.b).asUInt), 1.S, 0.S)

  io.out := 0.S
  
  io.out := MuxCase(0.S , Array(
    (io.sel === 0.U) -> adder,
    (io.sel === 1.U) -> sub,
    (io.sel === 2.U) -> and,
    (io.sel === 3.U) -> or,
    (io.sel === 4.U) -> xor,
    (io.sel === 5.U) -> srl.asSInt,
    (io.sel === 6.U) -> sra,
    (io.sel === 7.U) -> sll.asSInt,
    (io.sel === 8.U) -> slt,
    (io.sel === 9.U) -> sltu,
    (io.sel === 14.U) -> io.b,
    (io.sel === 15.U) -> io.b
  ))

}

