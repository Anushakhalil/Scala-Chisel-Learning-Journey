package lab8
import chisel3._
import chisel3.util._

class Ex_1 extends Module {
val width : Int = 8

val io = IO( new Bundle {
val enable = Input( Bool())
val write = Input( Bool())
val addr = Input( UInt(10.W))
val mask = Input( Vec(4,Bool()))
val dataIn = Input( Vec(4,UInt( width.W )))
val dataOut = Output( Vec(4,UInt( width.W )))
})

val mem = SyncReadMem(1024,Vec(4 , UInt(width.W )))
// mem.write( io.addr , io.dataIn , io.mask )

val a =  Reg(Vec(4,UInt()))
a(0) := io.dataIn(0) & io.mask(0)
a(1) := io.dataIn(1) & io.mask(1)
a(2) := io.dataIn(2) & io.mask(2)
a(3) := io.dataIn(3) & io.mask(3)

when(io.write){
    mem.write(io.addr, a)
}

io.dataOut := mem.read(io.addr,io.enable)
}