package lab7
import chisel3._
import org.scalatest._ 
import chiseltest._

class Task2Test extends FreeSpec with ChiselScalatestTester{
    "Task2 Test" in{
        test(new Task2){ c =>

            c.io.in.poke(1.U)
            c.io.start.poke(1.B)
            c.clock.step(1)

            c.io.in.poke(0.U)
            c.io.start.poke(1.B)
            c.clock.step(1)

            c.io.in.poke(0.U)
            c.io.start.poke(1.B)
            c.clock.step(1)

            c.io.in.poke(1.U)
            c.io.start.poke(1.B)
            c.clock.step(1)

            c.io.in.poke(0.U)
            c.io.start.poke(1.B)
            c.clock.step(1)

            c.io.in.poke(1.U)
            c.io.start.poke(1.B)
            c.clock.step(1)

            c.io.in.poke(0.U)
            c.io.start.poke(1.B)

        }

    }

}