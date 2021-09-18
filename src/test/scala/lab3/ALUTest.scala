package lab3
import chiseltest._
import chisel3._
import org.scalatest._

class ALUTest extends FreeSpec with ChiselScalatestTester{
  "ALU Test" in {
    test(new ALU()){ c =>
        c.io.in_A.poke(6.U)
        c.io.in_B.poke(4.U)
        c.io.alu_Op.poke(11.U)
        c.clock.step(1)
        c.io.out.expect(4.U)  
        c.io.sum.expect(10.U)
    }
  }
}