package example
import org.scalatest._
import chiseltest._
import chisel3._

class fourToOneMuxTest extends FreeSpec with ChiselScalatestTester{
  "Four To One Mux" in {
    test(new fourToOneMux()){ c =>
      c.io.a.poke(0.U)
      c.io.b.poke(1.U)
      c.io.c.poke(0.U)
      c.io.d.poke(1.U)
      c.io.sel0.poke(1.U)
      c.io.sel1.poke(0.U)
      c.clock.step(1)
      c.io.out.expect(0.U)
    }
  }
}