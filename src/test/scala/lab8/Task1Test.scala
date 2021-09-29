package lab8
import chisel3._ 
import org.scalatest._ 
import chiseltest._

class Task1Test extends FreeSpec with ChiselScalatestTester{
    "Task 1 test" in{
        test( new Task1){c=> 
            c.io.requestor(0).bits.poke(12.U)
            c.io.requestor(1).bits.poke(0.U)
            c.io.requestor(2).bits.poke(0.U)
            c.io.requestor(3).bits.poke(0.U)

            c.io.requestor(0).valid.poke(1.B)
            c.io.requestor(1).valid.poke(1.B)
            c.io.requestor(2).valid.poke(1.B)
            c.io.requestor(3).valid.poke(1.B)

            c.io.writeaddr.poke(2.U)
            c.clock.step(2)

            c.io.requestor(0).bits.poke(13.U)
            c.io.requestor(1).bits.poke(1.U)
            c.io.requestor(2).bits.poke(0.U)
            c.io.requestor(3).bits.poke(0.U)

            c.io.requestor(0).valid.poke(1.B)
            c.io.requestor(1).valid.poke(1.B)
            c.io.requestor(2).valid.poke(1.B)
            c.io.requestor(3).valid.poke(1.B)

            c.io.writeaddr.poke(1.U)
            c.io.readaddr.poke(2.U)
            c.clock.step(2)

            c.io.requestor(0).bits.poke(14.U)
            c.io.requestor(1).bits.poke(0.U)
            c.io.requestor(2).bits.poke(1.U)
            c.io.requestor(3).bits.poke(0.U)

            c.io.requestor(0).valid.poke(1.B)
            c.io.requestor(1).valid.poke(1.B)
            c.io.requestor(2).valid.poke(1.B)
            c.io.requestor(3).valid.poke(1.B)

            c.io.writeaddr.poke(3.U)
            c.io.readaddr.poke(1.U)
            c.clock.step(2)

            // c.io.requestor(0).bits.poke(15.U)
            // c.io.requestor(1).bits.poke(0.U)
            // c.io.requestor(2).bits.poke(0.U)
            // c.io.requestor(3).bits.poke(1.U)

            // c.io.requestor(0).valid.poke(1.B)
            // c.io.requestor(1).valid.poke(1.B)
            // c.io.requestor(2).valid.poke(1.B)
            // c.io.requestor(3).valid.poke(1.B)

            // c.io.writeaddr.poke(5.U)
            c.io.readaddr.poke(3.U)
            c.clock.step(2)

        
        }
    }

}