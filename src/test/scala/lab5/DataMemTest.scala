package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class DataMemTest extends FreeSpec with ChiselScalatestTester{
 "data memory test" in{

     test(new DataMem(new Parameters(35,5))){ c =>
        c.io.data_in.poke(12.U)
        c.io.addr.poke(2.U)
        c.io.wr_en.poke(1.B)
        c.clock.step(1)
        c.io.addr.poke(2.U)
        c.io.wr_en.poke(0.B)
        c.clock.step(1)
        c.io.data_out.expect(12.U)

    }
}
}