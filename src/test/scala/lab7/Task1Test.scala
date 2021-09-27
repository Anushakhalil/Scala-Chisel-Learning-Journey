package lab6
import chisel3._
import chiseltest._
import org.scalatest._

class Task1Test extends FreeSpec with ChiselScalatestTester{
    " Task1 test" in{
        test(new Task1()){c =>
        c.io.f1.poke(1.B)
        c.io.f2.poke(0.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)
        c.clock.step(1)

        c.io.f1.poke(1.B)
        c.io.f2.poke(0.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)
        c.clock.step(1)

        c.io.f1.poke(1.B)
        c.io.f2.poke(0.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)
        c.clock.step(1)

        c.io.f1.poke(0.B)
        c.io.f2.poke(1.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)
        c.clock.step(1)

        c.io.f1.poke(0.B)
        c.io.f2.poke(1.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)
        c.clock.step(1)

        c.io.f1.poke(0.B)
        c.io.f2.poke(0.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)
        c.clock.step(1)

        }
    }
}