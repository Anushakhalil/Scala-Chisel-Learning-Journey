package singleCycle
import chisel3._ 
import org.scalatest._ 
import chiseltest._ 

class AluControlTest extends FreeSpec with ChiselScalatestTester{
    "ALU CONTROL TEST" in{
        test(new AluControl){c =>
            c.io.func3inAC.poke(0.U)
            c.io.func7inAC.poke(0.U)
            c.io.opcFromControl.poke(5.U)
            c.io.aluControl.expect(0.U)
            c.clock.step(1)

        }
    }
}