package lab6
import chisel3._
import org.scalatest._
import chiseltest._ 

class Task4Test extends FreeSpec with ChiselScalatestTester{
    "Task 4" in{
        test( new Task4){ c => 
            c.io.up_down.poke(1.B)
            c.clock.step(5)
            c.io.up_down.poke(0.B)
            c.clock.step(5)
        }
    }
}