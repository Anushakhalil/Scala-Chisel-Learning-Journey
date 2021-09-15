package lab1
import chiseltest._
import chisel3._
import org.scalatest._

class Task5Test extends FreeSpec with ChiselScalatestTester{
  "Task5" in {
    test(new Task5(6)){ c =>
      c.io.reload.poke(true.B)
      c.clock.step(30)
    }
  }
}