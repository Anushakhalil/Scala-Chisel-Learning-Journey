package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class switch2CrossTest extends FreeSpec with ChiselScalatestTester{
    "Switch 2 cross tests" in{
        test(new switch2Cross(UInt(8.W))){c => 
            c.io.in1.poke(1.U)
            c.io.in2.poke(5.U)
            c.io.sel.poke(1.B)
            c.clock.step(1)
            c.io.out1.expect(5.U)
            c.io.out2.expect(1.U)
        
        }

    }

}