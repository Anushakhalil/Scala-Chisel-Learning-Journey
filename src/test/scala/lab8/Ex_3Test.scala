package lab8
import chisel3._ 
import chiseltest._ 
import org.scalatest._ 

class Ex_3Test extends FreeSpec with ChiselScalatestTester{
    "EX 3 Test" in{
        test(new Ex_3){ c => 
            c.io.addr.poke(1.U)
            c.clock.step(1)
            c.io.inst.expect(7.U)
        }

    }

}