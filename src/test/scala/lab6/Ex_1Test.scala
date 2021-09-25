package lab6
import chisel3._
import org.scalatest._
import chiseltest._

class Ex_1Test extends FreeSpec with ChiselScalatestTester{
    "shift register" in{
        test(new Ex_1()){c => 
            c.io.in.poke(4.U)
            c.io.reload.poke(1.B)
            c.clock.step(5)
            // c.io.out.expect(2.U)
        }
    }

}