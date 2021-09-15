package example
import org.scalatest._
import chisel3._
import chiseltest._

class twoBitAdderTest extends FreeSpec with ChiselScalatestTester{
  "Two Bit Adder" in {
    test(new twoBitAdder()){ c =>
      c.io.a0.poke(1.U)
      c.io.a1.poke(0.U)
      c.io.b0.poke(1.U)
      c.io.b1.poke(0.U)
      c.clock.step(1)
      c.io.c_out0.expect(1.U)
      c.io.c_out1.expect(0.U)
      c.io.sum0.expect(0.U)
      c.io.sum1.expect(0.U)

    }
  }
}