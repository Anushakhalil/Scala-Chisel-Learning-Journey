package lab3
import chiseltest._
import chisel3._
import org.scalatest._

class Task2Test extends FreeSpec with ChiselScalatestTester{
  "Immediate Generation Test Itype" in {
    test(new Task2()){ c =>
        c.io.instr.poke("h0000c537".U)
        c.clock.step(1)
        c.io.immd_se.expect(12.U)
    }
  }
}


// class Task2_1Test extends FreeSpec with ChiselScalatestTester{
//   "Immediate Generation Test Stype" in {
//     test(new Task2()){ c =>
//         c.io.instr.poke(10493987.U)
//         c.clock.step(1)
//         c.io.immd_se.expect(0.U)
//     }
//   }
// }


// class Task2_2Test extends FreeSpec with ChiselScalatestTester{
//   "Immediate Generation Test Utype" in {
//     test(new Task2()){ c =>
//         c.io.instr.poke(83383.U)
//         c.clock.step(1)
//         c.io.immd_se.expect(81920.U)
//     }
//   }
// }


// class Task2_3Test extends FreeSpec with ChiselScalatestTester{
//   "Immediate Generation Test Btype" in {
//     test(new Task2()){ c =>
//         c.io.instr.poke(5964899.U)
//         c.clock.step(1)
//         c.io.immd_se.expect(8.U)
//     }
//   }
// }


// class Task2_4Test extends FreeSpec with ChiselScalatestTester{
//   "Immediate Generation Test Jtype" in {
//     test(new Task2()){ c =>
//         c.io.instr.poke(4194543.U)
//         c.clock.step(1)
//         c.io.immd_se.expect(4.U)
//     }
//   }
// }