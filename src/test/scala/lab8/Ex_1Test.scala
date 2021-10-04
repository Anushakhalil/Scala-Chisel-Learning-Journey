package lab8
import org.scalatest._ 
import chisel3._
import chiseltest._

class Ex_1Test extends FreeSpec with ChiselScalatestTester{
    "Ex1 Test "in {
        test(new Ex_1){c => 
            c.io.enable.poke(1.B)
            c.io.write.poke(1.B)
            c.io.addr.poke(5.U)

            c.io.mask(0).poke(1.B)
            c.io.mask(1).poke(0.B)
            c.io.mask(2).poke(1.B)
            c.io.mask(3).poke(0.B)

            c.io.dataIn(0).poke(1.U)
            c.io.dataIn(1).poke(1.U)
            c.io.dataIn(2).poke(0.U)
            c.io.dataIn(3).poke(1.U)

            c.clock.step(1)

            c.io.enable.poke(1.B)
            c.io.write.poke(1.B)
            c.io.addr.poke(6.U)

            c.io.mask(0).poke(1.B)
            c.io.mask(1).poke(1.B)
            c.io.mask(2).poke(1.B)
            c.io.mask(3).poke(0.B)

            c.io.dataIn(0).poke(1.U)
            c.io.dataIn(1).poke(1.U)
            c.io.dataIn(2).poke(0.U)
            c.io.dataIn(3).poke(1.U)

            c.clock.step(1)

            c.io.enable.poke(1.B)
            c.io.write.poke(1.B)
            c.io.addr.poke(8.U)

            c.io.mask(0).poke(1.B)
            c.io.mask(1).poke(0.B)
            c.io.mask(2).poke(0.B)
            c.io.mask(3).poke(0.B)

            c.io.dataIn(0).poke(1.U)
            c.io.dataIn(1).poke(1.U)
            c.io.dataIn(2).poke(0.U)
            c.io.dataIn(3).poke(1.U)

            c.clock.step(1)

        }
    }

}