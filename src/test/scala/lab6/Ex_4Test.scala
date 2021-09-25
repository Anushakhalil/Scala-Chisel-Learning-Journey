package lab6
import chisel3._
import chiseltest._
import org.scalatest._

class Ex_4Test extends FreeSpec with ChiselScalatestTester{
    "Queue test" in{
         test(new Ex_4){ c =>
        c.io.in.valid.poke(1.B)
        c.io.in.bits.poke(2.U)
        c.io.out.ready.poke(1.B)
        c.clock.step(1)
        c.io.in.ready.expect(1.B)
        c.io.out.valid.expect(1.B)
        c.io.out.bits.expect(2.U)
        }
    }
}