package lab3
import chiseltest._
import chisel3._
import org.scalatest._

class Ex2Test extends FreeSpec with ChiselScalatestTester{
  "Switch ALu Test" in {
    test(new Ex2()){ c =>
        c.io.in_A.poke(6.U)
        c.io.in_B.poke(4.U)
        c.io.alu_Op.poke(0.U)
        c.clock.step(1)
        c.io.out.expect(10.U)  
        c.io.sum.expect(10.U)
    }
  }
}