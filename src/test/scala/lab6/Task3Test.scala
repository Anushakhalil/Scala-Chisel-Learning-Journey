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
            c.io.load.poke(1.B)
            c.io.in.poke(1.B)
            c.clock.step(1)
            c.io.out(0).expect(1.B)
            c.io.out(1).expect(1.B)
            c.io.out(2).expect(0.B)
            // c.io.out.expect(2.U)
        }
    }

}