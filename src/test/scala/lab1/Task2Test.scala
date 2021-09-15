package lab1
import org.scalatest
import chiseltest._
import chisel3._
import org.scalatest._

class Task2Test extends FreeSpec with ChiselScalatestTester{
  "Task2" in {
    test(new Task2(4.U)){ c =>
      c.clock.step(10)
    }
  }
}