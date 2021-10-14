package lab3
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
class LM_IO_Interface_ImmdValGen extends Bundle{
    val instr = Input(UInt(32.W))
    val immd_se = Output(UInt(32.W))
    }

class Task2 extends Module{
    val io = IO (new LM_IO_Interface_ImmdValGen)
    val zero5bit = Fill(5, 0.U)

    val immm_B = Cat(io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8), 0.U)
    val immm_J = Cat(io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21), 0.U)
    
    val I = Cat(Fill(20,io.instr(31)),io.instr(31,20))

    val S = Cat(Fill(20,io.instr(31)),io.instr(31,25),io.instr(11,7))

    val U = (Cat(Fill(12,io.instr(31)),io.instr(31,12))) << zero5bit

    val B = Cat(Fill(18,io.instr(31)),immm_B)

    val J = Cat(Fill(10,io.instr(31)),immm_J)

    val bits0To6 = io.instr(6,0)
    
    val out = Mux( Itype === bits0To6 , I, Mux(Utype === bits0To6, U, Mux( Stype === bits0To6, S,
    Mux(Btype === bits0To6, B, Mux(Jtype === bits0To6, J, 0.U
    )))))

    io.immd_se := out
}