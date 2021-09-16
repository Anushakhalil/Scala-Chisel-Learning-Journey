package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Task1Test extends FreeSpec with ChiselScalatestTester{
  "Task 1 Test" in {
    test(new Task1()){ c =>
      c.io.s2.poke(false.B)
      c.io.s1.poke(false.B)
      c.io.s0.poke(true.B)
      c.clock.step(1)
      c.io.out.expect(32.U)
    }
  }
}
