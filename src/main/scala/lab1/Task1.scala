// ----------------------------------------- Chisel Datatypes -------------------------------------
package lab1
import chisel3._

class Task1 (counterBits : UInt) extends Module {
  val io = IO (new Bundle{
    val result = Output(Bool())
  })
  val max = ((1.U << counterBits ) -1.U).asSInt()   //
  val count = RegInit(0.S(4.W))    // 0 -15

  when(count === max){
    count := 0.S
  }.otherwise{
    count := count + 1.S
  }
  io.result := count(3.U)  // Bool kbh Sint pe apply nh hogaa
  println (s"counter created with max value ",max)
}