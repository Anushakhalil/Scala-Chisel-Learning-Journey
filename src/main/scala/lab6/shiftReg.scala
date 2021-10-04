package lab6 
import chisel3._

class shiftReg( val init : Int = 1) extends Module {
    val io = IO ( new Bundle {
        val in = Input (UInt(4.W))
        val out = Output (UInt(4.W ))
})
    
    val state = RegInit ( init.U(4.W ) )
    // register initialization

    // serial data in at LSB
    val nextState = ( state << 1) | io.in 
    state := nextState
    io.out := state
}