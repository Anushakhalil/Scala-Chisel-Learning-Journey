package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class TopTest extends FreeSpec with ChiselScalatestTester{
    "Top test" in {
        test( new Top(18,30,32)){ c =>
            c.io.in.poke(5.U)
            c.clock.step(20)
            c.io.out.expect(10.U)

        }
    }

}