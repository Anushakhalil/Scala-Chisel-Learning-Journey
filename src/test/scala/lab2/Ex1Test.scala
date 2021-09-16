package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Ex1Test extends FreeSpec with ChiselScalatestTester{
  "Ex 1 Test" in {
    test(new Ex1()){ c =>
      //      c.io.data_in.poke(40.U)
      c.io.in_A.poke(16.U)
      c.io.in_B.poke(18.U)
      c.io.select.poke(true.B)
      c.clock.step(1)
      c.io.out.expect(18.U)
    }
  }
}