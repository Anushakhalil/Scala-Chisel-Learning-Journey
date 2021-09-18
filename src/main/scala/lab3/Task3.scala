package lab3
import chisel3._
import chisel3.util._

    
class LM_IO_Interface_decoder_with_valid extends Bundle {
    val in = Input(UInt(2.W))
    val out = Valid(UInt(4.W))
    }

class Task3 extends Module {
    val io = IO(new LM_IO_Interface_decoder_with_valid)
    io.out.valid := true.B
    
    val out0 = Mux(io.in === 0.U, 1.U ,0.U)
    val out1 = Mux(io.in === 1.U, 1.U ,0.U)
    val out2 = Mux(io.in === 2.U, 1.U ,0.U)
    val out3 = Mux(io.in === 3.U, 1.U ,0.U)

    io.out.bits := Cat(out3,out2,out1,out0)
}
