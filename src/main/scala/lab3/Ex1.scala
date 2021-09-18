package lab3
import chisel3._
import chisel3.util._

class Encoder extends Bundle{
    val in = Input(UInt(4.W))
    val out = Output(UInt(2.W))
}

class Ex1 extends Module{
    val io = IO(new Encoder)
    io.out := 0.U
    switch (io.in){
        is (1.U){
            io.out := "b00".U
        }
        is (2.U){
            io.out := "b01".U
        }
        is (4.U){
            io.out := "b10".U
        }
        is (8.U){
            io.out := "b11".U
        }
    }
}