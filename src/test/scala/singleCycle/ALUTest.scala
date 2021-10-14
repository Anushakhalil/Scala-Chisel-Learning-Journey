// package singleCycle
// import org.scalatest._
// import chiseltest._
// import chisel3._

// class ALUTest extends FreeSpec with ChiselScalatestTester{
//   "Alu Test" in {
//     test(new ALU()){ c =>
//       c.io.a.poke(4.S)
//       c.io.b.poke(3.S)
//       c.io.sel.poke(2.U)
//       c.clock.step(1)
//       c.io.out.expect(0.S)
//     }
//   }
// }
