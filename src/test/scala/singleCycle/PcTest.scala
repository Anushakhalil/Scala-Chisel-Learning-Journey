package singleCycle
import chisel3._ 
import chiseltest._ 
import org.scalatest._ 

class PcTest extends FreeSpec with ChiselScalatestTester{
    "Pc Test" in{
        test(new pc){ c => 
            c.io.input.poke(4.S)
            c.clock.step(1)
            c.io.output.expect(4.S)
            c.io.pc_4.expect(8.S)
        }

    }

}