package example
import org.scalatest._
import chiseltest._
import chisel3._

class MuxTest extends FreeSpec with ChiselScalatestTester{
  "Mux" in {
    test(new Mux()){ c =>
      c.io.a.poke(0.U)
      c.io.b.poke(1.U)
      c.io.sel.poke(0.U)
      c.clock.step(1)
      c.io.out.expect(0.U)
    }
  }
}