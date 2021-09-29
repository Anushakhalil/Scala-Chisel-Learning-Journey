package lab7
import chisel3._
import chisel3.util._
// import chisel.iotesters._
// import chisel3.experimental.ChiselEnum
// import chisel3.experimental.{withClock , withReset , withClockAndReset}
// import chisel3.experimental.BundleLiterals._

class Task2 extends Module{

    val io = IO ( new Bundle {
    val in = Input( UInt(1.W ))
    val start = Input( Bool())
    val out = Output(UInt(8.W ))
    val flag = Output( UInt(1.W ))
    })
    
    val s0 :: s1 :: Nil = Enum(2)
    val State = RegInit(s0)

    io.out := 0.U
    io.flag := 0.U

    val state = RegInit(0.U(8.W))
    
    switch(state){
        is(s0){
            when(io.start & io.in === 1.U){
            val nextState = (state << 1 ) | 0.U
            state := nextState
            io.out := state
            io.flag := 1.U
            State := s1
            }
        }
        is(s1){
            when(io.start &  io.in === 0.U){
            val nextState = (state << 1 ) | 1.U
            state := nextState
            io.out := state
            io.flag := 0.U
            State := s0
            }
        }
    }
}