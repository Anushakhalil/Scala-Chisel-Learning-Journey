package lab1
import org.scalatest._
import chiseltest._
import chisel3._
//import chiseltest.experimental.TestOptionBuilder._
//import chiseltest.internal.VerilatorBackendAnnotation

class counterFullImpTest extends FreeSpec with ChiselScalatestTester{
  "counter Full Imp" in {
    test(new counterFullImp(16.U)){ c => // 32 16 8 4 2 1 0
      c.clock.step(30)
    }
  }
}