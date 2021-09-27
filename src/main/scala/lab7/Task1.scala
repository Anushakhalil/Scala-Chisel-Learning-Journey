package lab6
import chisel3._
import chisel3.util._


class Task1 extends Module {
    val io = IO ( new Bundle {
    val f1 = Input(Bool())
    val r1 = Input(Bool())
    val f2 = Input(Bool())
    val r2 = Input(Bool())
    val out = Output(UInt(3.W))
    })

    val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum (6)
    val state = RegInit(s0)

    io.out := 0.U
    val cat = Cat(io.f1,io.f2,io.r1,io.r2)

    switch ( state ) {
        is ( s0 ) {
            when(cat === BitPat("b11??")){
                state := s1
                io.out := 0.U
            }.elsewhen(cat === BitPat("b10??")){
                state := s1
                io.out := 0.U
            }.elsewhen(cat === BitPat("b01??")){
                state := s5
                io.out := 0.U
            }.otherwise{
                state := s0
                io.out := 0.U
            }
        }

        is ( s1 ) {   
            when(cat === BitPat("b1???")){
                state := s2
                io.out := 0.U
            }.elsewhen(cat === BitPat("b0?1?")){
                state := s0
                io.out := 0.U
            }.otherwise{
                state := s1
                io.out := 0.U
            }
        }

        is ( s2 ) {  
            when(cat === BitPat("b1???")){
                state := s3
                io.out := 3.U
            }.elsewhen(cat === BitPat("b0?1?")){
                state := s1
                io.out := 3.U
            }.otherwise{
                state := s2
                io.out := 3.U
            }
        }

        is ( s3 ) {
            state := s0
        }

        is ( s4 ) {
            when(cat === BitPat("b?1??")){
                state := s3
                io.out := 7.U
            }.elsewhen(cat === BitPat("b?0?1")){
                state := s5
                io.out := 7.U
            }.otherwise{
                state := s4
                io.out := 7.U
            }
        }
        is ( s5 ) {
            when(cat === BitPat("b?1??")){
                state := s4
                io.out := 0.U
            }.elsewhen(cat === BitPat("b?0?1")){
                state := s0
                io.out := 0.U
            }.otherwise{
                state := s5
                io.out := 0.U
            }
        }
    }
}   