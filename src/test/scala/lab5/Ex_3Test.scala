// package lab5
// import chisel3._
// import org.scalatest._
// import chiseltest._

// class Ex_3Test extends FreeSpec with ChiselScalatestTester{
//     "operator test" in{
//         test (new Ex_3(5 , UInt(16. W ))( _ + _ )){c => // here the op defined 
//             c.io.in(0).poke(10.U)                        // perform add operation 
//             c.io.in(1).poke(2.U)
//             c.io.in(2).poke(5.U)
//             c.clock.step(1)
//             c.io.out(0).expect(12.U)
//             // c.io.out(1).expect(7.U)
//             // c.io.out(2).expect(8.U)
//         }
//     }
// }