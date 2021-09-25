package lab6
import chisel3._
import chiseltest._
import org.scalatest._

class Ex_2Test extends FreeSpec with ChiselScalatestTester{
    " counter test" in{
        test(new Ex_2(5)){c => 
            c.clock.step(20)
        }
    }

}