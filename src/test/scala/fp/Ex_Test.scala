package fp
import chisel3._
import org.scalatest._
import chiseltest._ 


class Ex_Test extends FreeSpec with ChiselScalatestTester{
    "two module test" in{
        test(new Ex(new Add, new Sub)){ c=> 
            c.io.in1.poke(3.U)
            c.io.in2.poke(0.U)
            c.clock.step(1)
            c.io.out1.expect(3.U)
            c.io.out2.expect(3.U)
        }
    }

}