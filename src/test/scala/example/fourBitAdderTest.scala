package example
import org.scalatest._
import chisel3._
import chiseltest._

class fourBitAdderTest extends FreeSpec with ChiselScalatestTester{
  "Four Bit Adder" in {
    test(new fourBitAdder()){ c =>
      c.io.a0.poke(1.U)
      c.io.a1.poke(0.U)
      c.io.a2.poke(1.U)
      c.io.a3.poke(1.U)
      c.io.b0.poke(1.U)
      c.io.b1.poke(1.U)
      c.io.b2.poke(0.U)
      c.io.b3.poke(1.U)
      c.clock.step(1)
      c.io.c_out0.expect(1.U)
      c.io.c_out1.expect(0.U)
      c.io.sum0.expect(0.U)
      c.io.sum1.expect(1.U)
      c.io.c_out2.expect(0.U)
      c.io.c_out3.expect(1.U)
      c.io.sum2.expect(1.U)
      c.io.sum3.expect(0.U)

    }
  }
}