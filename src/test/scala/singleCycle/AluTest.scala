package singleCycle
import org.scalatest._
import chiseltest._
import chisel3._

class AluTest extends FreeSpec with ChiselScalatestTester{
  "Alu Test" in {
    test(new Alu()){ c =>
      c.io.a.poke(6.S)
      c.io.b.poke(4.S)
      c.io.sel.poke(7.U)
      c.clock.step(1)
      c.io.out.expect(96.S)
    }
  }
}
