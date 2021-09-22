package lab5
import chisel3._
import org.scalatest._
import chiseltest._ 

class Task2Test extends FreeSpec with ChiselScalatestTester{
    "Task2 Test" in {
        test(new Task2(UInt(5.W))){ c =>
        c.io.in.datafield.poke(3.U)
        c.io.in.addrfield.poke(5.U)
        c.clock.step(1)
        c.io.out.datafield.expect(3.U)
        c.io.out.addrfield.expect(5.U)
        }
    }
}