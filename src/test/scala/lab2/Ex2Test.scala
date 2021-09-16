package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Ex2Test extends FreeSpec with ChiselScalatestTester{
  "Ex 2 Test" in {
    test(new Ex2()){ c =>
      c.io.in.poke("b00010000".U)
      c.io.sel0.poke(false.B)
      c.io.sel1.poke(false.B)
      c.io.sel2.poke(true.B)
      c.clock.step(1)
      c.io.out.expect(true.B)
    }
  }
}