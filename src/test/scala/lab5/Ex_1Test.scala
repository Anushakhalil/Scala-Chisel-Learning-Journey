package lab5
import org.scalatest._
import chiseltest._
import chisel3._

class Ex_1Test extends FreeSpec with ChiselScalatestTester{
  "Alu Test" in {
    test(new Ex_1(32)){ c =>
      c.io.arg_x.poke(0.U)
      c.io.arg_y.poke(6.U)
      c.io.alu_oper.poke(8.U)
      c.clock.step(1)
      c.io.alu_out.expect(1.U)
    }
  }
}
