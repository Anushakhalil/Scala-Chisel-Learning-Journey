package lab5
import org.scalatest._
import chisel3._
import chiseltest._


class AdderTest extends FreeSpec with ChiselScalatestTester{
    "Adder test" in {
        test(new Adder(15.U)){ c=>
            c.io.ina.poke(3.U)
            c.io.inb.poke(2.U)
            c.io.sel.poke(0.B)
            c.clock.step(1)
            c.io.out.expect(0.U)
        }

    }

}