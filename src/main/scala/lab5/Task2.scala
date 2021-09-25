package lab5
import chisel3._
import chisel3.util._

class datapacket[T <: Data]( gen: T) extends Bundle{
    val datafield = gen
    val addrfield = UInt(10.W)
}

class Task2[ T <: Data ]( gen : T ) extends Module {
    val io = IO(new Bundle {
        val out = Output(new datapacket(gen))
        val in = Input(new datapacket(gen))
    })
// --> this
    // io.out.datafield := io.in.datafield
    // io.out.addrfield := io.in.addrfield
// Or
// -- > this
    io.out <> io.in
}