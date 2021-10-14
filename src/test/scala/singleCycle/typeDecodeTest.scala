package singleCycle
import chisel3._ 
import org.scalatest._ 
import chiseltest._ 

class typeDecodeTest extends FreeSpec with ChiselScalatestTester{
    "TYPE DECODE TEST" in{
        test(new typeDecode){c =>
            c.io.Opcode.poke("b0010111".U)
            c.clock.step(1)
            c.io.Auipc.expect(1.B)

        }
    }
}