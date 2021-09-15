
package lab1
import chisel3._

class Task2 (counterBits : UInt) extends Module {
  val io = IO(new Bundle {
    val result = Output(Bool())
  })
  val count = RegInit(0.U(4.W))
  val max = (1.U << counterBits ) - 1.U

  when(count === max) {
    when(count(3.U) === 1.U) {
      count := 0.U
    }
  }.otherwise {
    count := count + 1.U
  }
  io.result := count(3.U)
}