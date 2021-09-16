package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Mem_bundle_IntfTest extends FreeSpec with ChiselScalatestTester{
  "Eg Test" in {
    test(new Mem_bundle_Intf()){ c =>
//      c.io.data_in.poke(40.U)
      c.io.data_selector.poke("b11".U)
      c.io.addr.poke("b11111".U)
      c.io.wr_en.poke(true.B)
      c.clock.step(1)
      c.io.data_out.expect("b000000".U)
    }
  }
}