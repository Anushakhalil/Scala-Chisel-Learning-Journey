package lab6
import chisel3._
import org.scalatest._ 
import chiseltest._

class PWMTest extends FreeSpec with ChiselScalatestTester{
    "PWM" in {
        test( new PWM() ){c=> 
            c.clock.step(5)
            // c.io.out.expect()
        }
    }
}