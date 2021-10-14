package singleCycle
import chisel3._ 
import chiseltest._ 
import org.scalatest._ 

class immgenTest extends FreeSpec with ChiselScalatestTester{
    "imm gen Test" in{
        test(new ImmGen){ c => 
            c.io.instr.poke("h0007b537".U)
            c.io.mux_sel.poke(2.U)
            c.clock.step(1)
            c.io.immd_se.expect(123.S)
            // c.io.B.expect()
            // c.io.J.expect(24.S)
            
        }

    }

}