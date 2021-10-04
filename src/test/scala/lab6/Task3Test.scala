package lab6
import chisel3._
import org.scalatest._
import chiseltest._

class Task3Test extends FreeSpec with ChiselScalatestTester{
    "Task 3" in{
        test(new Task3()){c => 
            c.io.load_in(0).poke(1.B)
            c.io.load_in(1).poke(0.B)
            c.io.load_in(2).poke(1.B)

            c.io.in.poke(0.B)
            
            c.io.load.poke(0.B)
            c.clock.step(1)

            c.io.load.poke(1.B)
            c.clock.step(1)

            c.io.load.poke(0.B)
            c.clock.step(1)

            c.io.load.poke(1.B)
            c.clock.step(1)

            c.io.load.poke(0.B)
            c.clock.step(1)

            c.io.load.poke(1.B)
            c.clock.step(1)

            // c.io.load.poke(0.B)
            // c.clock.step(1)

            // c.io.load.poke(1.B)
            // c.clock.step(1)

        }
    }

}