package singleCycle
import chisel3._
import chisel3.util._


class Parameters(dWidth: Int, aWidth: Int) extends Bundle with Config{
    val addrWidth = TYPE(aWidth.W)
    val dataWidth = SInt(dWidth.W)
}

class mainMem(params: Parameters) extends Module{

    val io = IO(new Bundle{
        val data_in = Input(params.dataWidth)
        val data_out = Output(params.dataWidth)
        val addr = Input(params.addrWidth)
        val wr_en = Input(Bool())
        val read = Input(Bool())
    })

    val memory = Mem(32, params.dataWidth) // memory of 32 X 32
    io.data_out := 0.S

    when(io.wr_en === 1.B & io.read === 0.B){
        memory.write(io.addr, io.data_in)
        io.data_out := 0.S
        
    }.otherwise{
        io.data_out := memory.read(io.addr)
    }
}