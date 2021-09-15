package lab1
import org.scalatest
import chiseltest._
import chisel3._
import org.scalatest._

class Task3Test extends FreeSpec with ChiselScalatestTester{
  "Task3" in {
    test(new Task3(4,15)){ c => // 32 16 8 4 2 1 0
      c.clock.step(10)
//      c.io.result.expect(false.B)
    }
  }
}