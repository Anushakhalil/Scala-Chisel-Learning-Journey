package lab3
import chiseltest._
import chisel3._
import org.scalatest._

class Task3Test extends FreeSpec with ChiselScalatestTester{
  "Decoder Valid Test" in {
    test(new Task3()){ c =>
        c.io.in.poke(3.U)
        c.clock.step(1)
        c.io.out.valid.expect(1.B)
        c.io.out.bits.expect(8.U)
    }
  }
}
