package lab5
import chisel3._
import org.scalatest._
import chiseltest._

class OperatorTest extends FreeSpec with ChiselScalatestTester{
    "operator test" in{
        test (new Operator(3 , UInt(16. W ))( _ + _ )){c =>
            c.io.in(0).poke(10.U)
            c.io.in(1).poke(4.U)
            c.io.in(2).poke(3.U)
            c.clock.step(1)
            c.io.out.expect(17.U)
        }
    }
}
