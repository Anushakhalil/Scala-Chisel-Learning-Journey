package lab3
import chiseltest._
import chisel3._
import org.scalatest._

class Task1Test extends FreeSpec with ChiselScalatestTester{
  "Branch Module Test" in {
    test(new Task1()){ c =>
        c.io.func3.poke(7.U)
        c.io.branch.poke(1.B)
        c.io.arg_x.poke(11.U)
        c.io.arg_y.poke(10.U)
        c.clock.step(1)
        c.io.br_taken.expect(1.B)
    }
  }
}
