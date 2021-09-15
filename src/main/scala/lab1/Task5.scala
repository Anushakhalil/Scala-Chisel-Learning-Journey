package lab1
import chisel3._
import chisel3.util._
import java.io.File

class Task5(n : Int) extends Module {
  val io = IO(new Bundle {
    val data_in = Input(UInt(n.W))
    val reload = Input(Bool())
    val out = Output(Bool())
  })
  val counter = RegInit(0.U(n.W))
  val max_count = RegInit(6.U(n.W))
  val indicator = RegInit(false.B)

  io.out := 0.U

  when(io.reload === true.B) {
    when(indicator === false.B) {
      when(counter === max_count) {
        io.out := 1.U
        counter := counter - 1.U
        indicator := true.B
      }.otherwise {
        counter := counter + 1.U
      }
    }.otherwise {
      when(counter === 0.U) {
        io.out := 1.U
        counter := counter + 1.U
        indicator := false.B
      }.otherwise {
        counter := counter - 1.U
      }
    }
    }.otherwise {
    io.out := DontCare
  }
}