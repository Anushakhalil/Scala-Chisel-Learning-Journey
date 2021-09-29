package lab6
import chisel3._ 
import chiseltest._ 
import org.scalatest._ 

class Ex_3Test extends FreeSpec with ChiselScalatestTester{
    "two shot counter" in {
        test(new Ex_3){ c =>
            // c.io.din.poke(2.U)
            c.io.reload.poke(1.B)
            c.clock.step(2)
        }

    }

}