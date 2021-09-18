package lab3
import chiseltest._
import chisel3._
import org.scalatest._

class Decoder2To4Test extends FreeSpec with ChiselScalatestTester{
  "Decoder2to4 Test" in {
    test(new Decoder2To4()){ c =>
      c.io.in.poke("b00".U)
      c.clock.step(1)
      c.io.out.expect("b0001".U)
    }
  }
}