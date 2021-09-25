package lab6
import chisel3._
import chiseltest._
import org.scalatest._

class counterTest extends FreeSpec with ChiselScalatestTester{
    " counter test" in{
        test(new counter(5)){c => 
            c.clock.step(20)
        }
    }

}