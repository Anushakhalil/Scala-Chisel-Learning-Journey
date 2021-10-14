// package singleCycle
// import chisel3._
// import org.scalatest._
// import chiseltest._

// class mainMemTest extends FreeSpec with ChiselScalatestTester{
//  "data memory test" in{

//      test(new mainMem(new Parameters(32,10))){ c =>
//         c.io.data_in.poke(23.S)
//         c.io.addr.poke(2.U)
//         c.io.wr_en.poke(1.B)
//         c.clock.step(1)
//         c.io.addr.poke(2.U)
//         c.io.wr_en.poke(0.B)
//         c.clock.step(1)
//         c.io.data_out.expect(23.S)

//         }
//     }
// }