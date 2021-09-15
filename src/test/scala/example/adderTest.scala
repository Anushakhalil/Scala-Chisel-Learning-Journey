package example
import org.scalatest
import chiseltest._
import chisel3._
import org.scalatest._

class adderTest extends FreeSpec with ChiselScalatestTester{
  "adder" in {
    test(new adder()){ c =>
      c.io.a.poke(1.U)
      c.io.b.poke(1.U)
      c.clock.step(1)
      c.io.c_out.expect(1.U)
      c.io.sum.expect(0.U)
    }
  }
}