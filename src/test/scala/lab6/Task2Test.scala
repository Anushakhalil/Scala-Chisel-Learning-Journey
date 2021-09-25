package lab6
import org.scalatest
import chiseltest._
import chisel3._
import org.scalatest._

class Task2Test extends FreeSpec with ChiselScalatestTester{
  "Task2" in {
    test(new Task2()){ c => 
    c.clock.step(5)
    // c.io.out.expect(2.U)

    }
  }
}