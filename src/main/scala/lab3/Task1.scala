package lab3
import chisel3._
import chisel3.util._

object funct3{
   val BEQ = 0.U(3.W)
   val BNE = 1.U(3.W)
   val BLT = 4.U(3.W)
   val BGE = 5.U(3.W)
   val BLTU = 6.U(3.W)
   val BGEU = 7.U(3.W)
}

import funct3._
class LM_IO_Interface_BranchControl extends Bundle {
    val func3 = Input(UInt(3.W))
    val branch = Input(Bool())
    val arg_x = Input(UInt(32.W))
    val arg_y = Input(UInt(32.W))
    val br_taken = Output(Bool())
}

class Task1 extends Module {
    val io = IO( new LM_IO_Interface_BranchControl )
    
    val compg = Mux((io.arg_x.asSInt > io.arg_y.asSInt), 1.U, 0.U)
    val compl = Mux((io.arg_x.asSInt < io.arg_y.asSInt), 1.U ,0.U)
    val compe = Mux((io.arg_x.asSInt === io.arg_y.asSInt), 1.U , 0.U)

    val compg_u = Mux((io.arg_x > io.arg_y), 1.U, 0.U)
    val compl_u = Mux((io.arg_x < io.arg_y), 1.U ,0.U)
    val compe_u = Mux((io.arg_x === io.arg_y), 1.U , 0.U)

    val out =
    Mux((io.branch === 1.B),
    Mux((io.func3 === BEQ), compe, 
    Mux((io.func3 === BNE), ~compe, 
    Mux((io.func3 === BLT), compl, 
    Mux((io.func3 === BGE), (compg | compe), 
    Mux((io.func3 === BLTU), compl_u, 
    Mux((io.func3 === BGEU), (compg_u | compe_u) , 0.U 
    )))))), 0.U)

    io.br_taken := out
}
