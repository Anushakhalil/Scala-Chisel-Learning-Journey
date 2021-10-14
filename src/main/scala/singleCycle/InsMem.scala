package singleCycle
import chisel3._
import chisel3.util.experimental.loadMemoryFromFile

class InsMem(string: String) extends Module with Config{
    val io = IO(new Bundle {
            val addr = Input(TYPE(10.W))
            val inst = Output(TYPE(WLEN.W))
    })

    val mem = Mem(1024, TYPE(WLEN.W))
    loadMemoryFromFile(mem, string)
    io.inst := mem(io.addr) 

}