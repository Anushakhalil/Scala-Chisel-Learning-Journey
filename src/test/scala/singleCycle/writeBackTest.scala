// package singleCycle
// import chisel3._
// import org.scalatest._
// import chiseltest._ 

// class writeBackTest extends FreeSpec with ChiselScalatestTester{
//     "write back module test" in{
//         test(new writeBackModule){c => 
//             c.io.sel_mux1.poke(1.B)
//             c.io.sel_mux2.poke(1.B)
//             c.io.in0_mux1.poke(12.U)
//             c.io.in1_mux1.poke(10.U)
//             c.io.in1_mux2.poke(1.U)
//             c.clock.step(1)
//             c.io.writeBackValue.expect(1.U)
//         }
//     } 
// }