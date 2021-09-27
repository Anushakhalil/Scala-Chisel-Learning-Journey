package lab7
import chisel3._
import chisel3.iotesters._

class Ex_1Test(c : Ex_1) extends PeekPokeTester(c) {
    poke(c.io.in , 2.U)
    step(1)
    expect(c.io.consumer,4.U)

}