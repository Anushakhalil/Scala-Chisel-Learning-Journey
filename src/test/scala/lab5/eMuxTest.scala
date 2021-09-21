package lab5
import org.scalatest._
import chisel3._
import chisel3.util._
import chiseltest._

class eMuxTest extends FreeSpec with ChiselScalatestTester{
    "Emux test" in{
        test(new eMux(SInt(2.W))){c => 
        c.io.in1.poke(1.S)
        c.io.in2.poke(2.S)
        c.io.sel.poke(1.B)
        c.clock.step(1)
        c.io.out.expect(1.S)

        }
    }

}