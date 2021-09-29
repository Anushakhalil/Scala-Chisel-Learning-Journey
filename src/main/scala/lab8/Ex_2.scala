package lab8
import chisel3._

class Ex_2 extends Module {
    val width : Int = 8

    val io = IO (new Bundle{
    val enable = Input(Bool()) // 1
    val write = Input(Bool())  // 1
    val wraddr = Input(UInt(10.W ))  // 5
    val rdaddr = Input(UInt(10.W ))  // 5
    val mask = Input(Vec(4 , Bool()))  // 5
    val dataIn = Input(Vec(4 , UInt(width.W )))  // 11
    val dataOut = Output(Vec(4 , UInt( width.W)))  //
    })

val mem = SyncReadMem(1024,Vec(4,UInt(width.W)))

val wrDataReg = RegNext(io.dataIn)
val doForwardReg = RegNext(io.wraddr === io.rdaddr && io.write)
when(io.write){
    mem.write(io.wraddr,io.dataIn, io.mask)
}
val memData = mem.read(io.rdaddr , io.enable)

io.dataOut := Mux(doForwardReg , wrDataReg , memData )
io.dataOut := memData

}