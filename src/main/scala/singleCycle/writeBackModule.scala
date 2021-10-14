package singleCycle
import chisel3._

class writeBackModule extends Module with Config{
    val io = IO(new Bundle{
        val sel_mux1 = Input(Bool()) 
        val sel_mux2 = Input(Bool())
        val in0_mux1 = Input(SInt(WLEN.W))
        val in1_mux1 = Input(SInt(WLEN.W))
        val in1_mux2 = Input(SInt(WLEN.W))
        val writeBackValue = Output(SInt(WLEN.W))
    })

    val in0_mux2 = Mux(io.sel_mux1, io.in1_mux1, io.in0_mux1)
    io.writeBackValue := Mux(io.sel_mux2, io.in1_mux2, in0_mux2)
    
}