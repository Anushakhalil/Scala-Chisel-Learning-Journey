package singleCycle
import chisel3._
import org.scalatest._
import chiseltest._

class TopTest extends FreeSpec with ChiselScalatestTester{
    "Top file" in{
        test(new Topfile ){ c =>
            c.clock.step(900)
            
        }
    }
}