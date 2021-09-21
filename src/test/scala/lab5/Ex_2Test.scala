package lab5
import org.scalatest._
import chisel3._
import chisel3.util._
import chiseltest._

class Ex_2Test extends FreeSpec with ChiselScalatestTester{
    "Emux test" in{
        test(new Ex_2(UInt(2.W))){c => 
        c.io.in1.poke(1.U)
        c.io.in2.poke(2.U)
        c.io.sel.poke(1.B)
        c.clock.step(1)
        c.io.out.expect(2.U)

        }
    }

}