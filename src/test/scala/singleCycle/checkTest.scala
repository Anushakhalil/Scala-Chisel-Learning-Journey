package singleCycle
import org.scalatest._
import chiseltest._
import chisel3._

class checkTest extends FreeSpec with ChiselScalatestTester{
  "Alu Test" in {
    test(new check()){ c =>
      c.io.a.poke(8.U)
      c.io.b.poke(6.U)
      c.clock.step(1)
      c.io.out.expect(0.U)
    }
  }
}
