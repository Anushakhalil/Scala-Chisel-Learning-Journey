package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Ex3Test extends FreeSpec with ChiselScalatestTester{
  "Ex 1 Test" in {
    test(new Ex3()){ c =>
      c.io.In.poke("b0010".U)
      c.clock.step(1)
      c.io.Out.expect("b01".U)
    }
  }
}