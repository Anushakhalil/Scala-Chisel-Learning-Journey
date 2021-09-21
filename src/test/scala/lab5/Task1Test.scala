package lab5
import org.scalatest._
import chisel3._
import chiseltest._


class Task1Test extends FreeSpec with ChiselScalatestTester{
    "Adder test" in {
        test(new Task1(5)){ c=>
            c.io.in0.poke(3.U)
            c.io.in1.poke(2.U)
            c.clock.step(1)
            c.io.sum.expect(5.U)
        }

    }

}