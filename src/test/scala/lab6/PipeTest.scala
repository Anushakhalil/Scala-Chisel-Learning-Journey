package lab6

import chisel3._
import chiseltest._
import org.scalatest._

class PipeTest extends FreeSpec with ChiselScalatestTester{
    "pipe and queue" in{
        test( new Pipe()){ c=>
            c.io.in.valid.poke(1.B)
            c.io.in.bits.poke(5.U)
            c.clock.step(1)
            c.io.out.valid.expect(1.B)
            c.io.out.bits.expect(5.U)

        }
    }

}