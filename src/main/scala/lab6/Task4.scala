package lab6
import chisel3._
import chisel3.util._

class Task4( val max : Int = 10, val min : Int = 0) extends Module {
    val io = IO(new Bundle{
    val out = Output(UInt(log2Ceil(max).W))
    val up_down = Input(Bool())
    })
    
    // val up_down = RegInit(true.B)
    val counter = RegInit(min.U(log2Ceil(max).W))

    when(io.up_down){
        when(counter === max.U){
            io.up_down := 0.B
            counter := counter - 1.U
            // counter := 0.U
        }.otherwise{
            counter := counter + 1.U
        }

    }.otherwise{
          when(counter === 0.U){
              io.up_down := 1.B
              counter := counter + 1.U
            //   counter := max.U
          }.otherwise{
              counter := counter - 1.U
          }
      }

    io.out := counter 
}