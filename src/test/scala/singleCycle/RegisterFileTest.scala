// package singleCycle
// import chisel3._
// import org.scalatest._
// import chiseltest._

// class RegisterFileTest extends FreeSpec with ChiselScalatestTester{
//     "reg file test" in {
        
//         test(new RegisterFile){ c =>

//             c.io.raddr1.poke(3.U)
//             c.io.raddr2.poke(2.U)
//             c.io.wen.poke(1.B)
//             c.io.waddr.poke(3.U)
//             c.io.wdata.poke(5.S)
//             c.clock.step(1)

//             c.io.raddr1.poke(3.U)
//             c.io.raddr2.poke(2.U)
//             c.io.wen.poke(1.B)
//             c.io.waddr.poke(2.U)
//             c.io.wdata.poke(6.S)
//             c.clock.step(2)

//             // c.io.rdata1.expect(3.S)
//             // c.io.rdata2.expect(2.S)

//             // c.clock.step(1)
//             // c.io.raddr1.poke(3.U)
//             // c.io.raddr2.poke(2.U)
//             // c.io.wen.poke(1.B)
//             // c.io.waddr.poke(5.U)
//             // c.io.wdata.poke(5.U)

//             // c.clock.step(1)
//             // c.io.raddr1.poke(3.U)
//             // c.io.raddr2.poke(2.U)
//             // c.io.wen.poke(1.B)
//             // c.io.waddr.poke(5.U)
//             // c.io.wdata.poke(5.U)

//             // c.clock.step(1)
//             // c.io.raddr1.poke(3.U)
//             // c.io.raddr2.poke(2.U)
//             // c.io.wen.poke(1.B)
//             // c.io.waddr.poke(5.U)
//             // c.io.wdata.poke(5.U)

//             // c.clock.step(1)
//             // c.io.raddr1.poke(3.U)
//             // c.io.raddr2.poke(2.U)
//             // c.io.wen.poke(1.B)
//             // c.io.waddr.poke(5.U)
//             // c.io.wdata.poke(5.U)


//         }
//     }
// }