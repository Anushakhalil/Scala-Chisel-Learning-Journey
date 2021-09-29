package lab8
import chisel3._
import chisel3.util._

class Task1 extends Module {
    val io = IO ( new Bundle {
    val memory_out = Vec(4 , Output( UInt(32.W)))
    val requestor = Vec(4 , Flipped( Decoupled(UInt(32.W ))))
    val readaddr = Input(UInt(5.W ))
    val writeaddr = Input( UInt(5.W ))
    })

    val mem = SyncReadMem(1024,Vec(4 ,UInt(32.W )))
    val arb = Module(new Arbiter(UInt(), 4))
    val some = Wire(Decoupled(UInt()))
    val output = Wire(Vec(4, UInt()))

    arb.io.in(0) <> Queue(io.requestor(0))
    arb.io.in(1) <> Queue(io.requestor(1))
    arb.io.in(2) <> Queue(io.requestor(2))
    arb.io.in(3) <> Queue(io.requestor(3))

    some <> arb.io.out
    some.ready := 1.B

    
    output(0) := some.bits
    output(1) := 0.U
    output(2) := 0.U
    output(3) := 0.U

    mem.write(io.writeaddr, output) // write 
    io.memory_out := mem.read(io.readaddr) // read

}