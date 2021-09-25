package lab6
import chisel3._
import org.scalatest._
import chiseltest._

class shiftRegTest extends FreeSpec with ChiselScalatestTester{
    "shift register" in{
        test(new shiftReg()){c => 
            c.io.in.poke(1.B)
            c.clock.step(1)
            c.io.out.expect(3.U)
        
        }
    }

}