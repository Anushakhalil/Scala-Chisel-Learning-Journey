package lab3
import chisel3._
import chisel3.util._

    
class LM_IO_Interface_decoder_with_valid extends Bundle {
    val in = Input(UInt(2.W))
    val out = Valid(UInt(4.W))
    }

class Task3 extends Module {
    val io = IO(new LM_IO_Interface_decoder_with_valid)
    io.out.valid := 0.B
    io.out.bits := 0.U

    switch (io.in){
    is (0.U){
    io.out.bits := 1.U
    io.out.valid := 1.B
    }
    is (1.U){
    io.out.bits := 2.U
    io.out.valid := 1.B
    }
    is (2.U){
    io.out.bits := 4.U
    io.out.valid := 1.B
    }
    is (3.U){
    io.out.bits := 8.U
    io.out.valid := 1.B
    }
    }
}