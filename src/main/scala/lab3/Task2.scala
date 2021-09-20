package lab3
import chisel3._
import chisel3.util._

object value{
    val Itype = 4.U(5.W)
    val Utype = 5.U(5.W)
    val Stype = 8.U(5.W)
    val Btype = 24.U(5.W)
    val Jtype = 27.U(5.W)
}

import value._
class LM_IO_Interface_ImmdValGen extends Bundle{
    val instr = Input(UInt(32.W))
    val immd_se = Output(UInt(32.W))
    }

class Task2 extends Module{
    val io = IO (new LM_IO_Interface_ImmdValGen)

    val zero5bit = Fill(5, 0.U)

    val immm_B = Cat(io.instr(31),io.instr(30,25),io.instr(11,8),io.instr(7),0.U)
    val immm_J = Cat(io.instr(30),io.instr(30,21),io.instr(20),io.instr(19,12), 0.U)
    
    val I = Cat(Fill(20,io.instr(31)),io.instr(31,20))

    val S = Cat(Fill(20,io.instr(31)),io.instr(31,25),io.instr(11,7))

    val U = (Cat(Fill(12,io.instr(31)),io.instr(31,12))) << zero5bit

    val B = Cat(Fill(19,io.instr(31)),immm_B)

    val J = Cat(Fill(11,io.instr(31)),immm_J)

    val bits2To6 = io.instr(6,2)
    // val out = Mux(Itype === bits2To6, I , 0.U)
    
    val out = Mux( Itype === bits2To6 , I, Mux(Utype === bits2To6, U, Mux( Stype === bits2To6, S,
    Mux(Btype === bits2To6, B, Mux(Jtype === bits2To6, J, 0.U
    )))))

io.immd_se := out
}