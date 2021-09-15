package lab1
import org.scalatest._
import chiseltest._
import chisel3._
//import chiseltest.internal.VerilatorBackendAnnotation
//import chiseltest.experimental.TestOptionBuilder._
//import chiseltest.internal.VerilatorBackendAnnotation

class Task1Test extends FreeSpec with ChiselScalatestTester{
  "Task1" in {
    test(new Task1(4.U)){ c => // 32 16 8 4 2 1 0
      c.clock.step(30)
    }
  }
}