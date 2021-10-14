package singleCycle
import chisel3._ 
import chiseltest._ 
import org.scalatest._ 

class InsMemTest extends FreeSpec with ChiselScalatestTester{
    "Instruction mem" in{
        test(new InsMem("/home/anusha/Scala-Chisel-Learning-Journey/src/main/scala/lab8/file.txt")){ c => 
            c.io.addr.poke(0.U)
            c.clock.step(3)
            // c.io.addr.poke(1.U)
            // c.clock.step(1)
            // c.io.addr.poke(2.U)
            // c.io.addr.poke(2.U)
            // c.io.addr.poke(2.U)
            // c.clock.step(1)
            // c.io.inst.expect("h0007b517".U)
        }

    }

}