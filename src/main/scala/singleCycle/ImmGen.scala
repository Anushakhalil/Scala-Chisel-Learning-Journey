package singleCycle
import chisel3._
import chisel3.util._

object value{
    val Itype = 19.U(7.W)
    val Utype = 55.U(7.W)
    val Stype = 35.U(7.W)
    val Btype = 99.U(7.W)
    val Jtype = 111.U(7.W)
}

import value._
class LM_IO_Interface_ImmdValGen extends Bundle with Config{
    val instr = Input(TYPE(WLEN.W))
    val mux_sel = Input(TYPE(WLEN.W))
    val immd_se = Output(SInt(WLEN.W))
    val B = Output(SInt(WLEN.W))
    val J = Output(SInt(WLEN.W))
    }


class ImmGen extends Module{
    val io = IO (new LM_IO_Interface_ImmdValGen)

    val immm_B = Cat(io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8), 0.S)
    val immm_J = Cat(io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21), 0.S)
    
    val ins20_31 = io.instr(31,20)
    val I = Cat(Fill(20,ins20_31(11)),ins20_31)

    val store = Cat(io.instr(31,25),io.instr(11,7))
    val S = Cat(Fill(20,store(11)),store)

    val utype = io.instr(31,12)
    val U = (Cat(Fill(12,utype(19)),utype)) << 12.U

    val B = Cat(Fill(19,immm_B(12)),immm_B)

    val J = Cat(Fill(11,immm_J(20)),immm_J)

    val bits0To6 = io.instr(6,0)
    
    // val out = Mux( io.mux_sel === 0.U , I, 
    // Mux( === bits0To6, U, 
    // Mux( Stype === bits0To6, S, 0.S
    // )))
    val out = MuxCase(0.S , Array(
    (io.mux_sel === 0.U) -> I.asSInt ,
    (io.mux_sel === 1.U ) -> S.asSInt, 
    (io.mux_sel === 2.U ) -> U.asSInt
    ))

    io.immd_se := out

    io.J := Mux(Jtype === bits0To6, J.asSInt, 0.S)
    io.B := Mux(Btype === bits0To6, B.asSInt, 0.S)
}