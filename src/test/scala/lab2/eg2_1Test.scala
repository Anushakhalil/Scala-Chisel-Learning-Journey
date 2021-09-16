package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class eg2_1Test extends FreeSpec with ChiselScalatestTester{
  "Eg Test" in {
    test(new eg2_1()){ c =>
      c.io.in0.poke(false.B)
      c.io.in1.poke(true.B)
      c.io.in2.poke(false.B)
      c.io.in3.poke(false.B)
      c.io.in4.poke(true.B)
      c.io.in5.poke(true.B)
      c.io.in6.poke(true.B)
      c.io.in7.poke(true.B)
      c.io.sel.poke("b000".U)
      c.clock.step(1)
      c.io.out.expect(false.B)
    }
  }
}