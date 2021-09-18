package lab3
import chiseltest._
import chisel3._
import org.scalatest._

class Ex1Test extends FreeSpec with ChiselScalatestTester{
  "Encoder4To2 Test" in {
    test(new Ex1()){ c =>
      c.io.in.poke(1.U)
      c.clock.step(1)
      c.io.out.expect("b00".U)
    }
  }
}