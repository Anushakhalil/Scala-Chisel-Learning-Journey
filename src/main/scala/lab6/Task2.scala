package lab6
import chisel3._
import chisel3.util._

class Task2(val max : Int = 3) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
    })

    io.out := 0.U
    val count = RegInit(0.U(3.W))

    when(count(2) === 1.U){
        count := 0.U
    }.otherwise{
        count := count ^ 1.U
    }
    
    io.out := count
}