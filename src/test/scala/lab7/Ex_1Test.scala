package lab7
import chisel3._
import org.scalatest._ 
import chiseltest._

class Ex_1Test extends FreeSpec with ChiselScalatestTester{
    "Ex_1 Test" in{
        test(new Ex_1){ c => 
        c.io.in.bits.poke(1.U)
        c.io.in2.bits.poke(2.U)

        // c.io.in3.bits.poke(3.U)

        c.io.in.valid.poke(1.B)
        c.io.in2.valid.poke(1.B)

        // c.io.in3.valid.poke(1.B)

        c.io.consumer.ready.poke(1.B)
        c.clock.step(5)
        // c.io.consumer.bits.expect(2.U)

        }
    }
}