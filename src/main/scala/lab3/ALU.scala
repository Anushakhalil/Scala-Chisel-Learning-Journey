package lab3
import chisel3._
import chisel3.util._

object ALUOP {
// ALU Operations , may expand / modify in future
val ALU_ADD= 0.U(4.W)
val ALU_SUB= 1.U(4.W)
val ALU_AND= 2.U(4.W)
val ALU_OR= 3.U(4.W)
val ALU_XOR= 4.U(4.W)
val ALU_SLT= 5.U(4.W)
val ALU_SLL= 6.U(4.W )
val ALU_SLTU= 7.U(4.W)
val ALU_SRL= 8.U(4.W )
val ALU_SRA= 9.U(4.W )
val ALU_COPY_A = 10.U(4.W )
val ALU_COPY_B = 11.U(4.W )
//val ALU_XXX= 15.U(4.W )
}

trait Config {
// word length configuration parameter

val WLEN= 32
// ALU operation control signal width

val ALUOP_SIG_LEN = 4
}

import ALUOP._
class ALUIO extends Bundle with Config{
val in_A = Input(UInt( WLEN.W ))
val in_B = Input(UInt( WLEN.W ))
val alu_Op = Input(UInt( ALUOP_SIG_LEN.W ))
val out = Output(UInt( WLEN.W ))
val sum = Output(UInt( WLEN.W ))
}

class ALU extends Module with Config{
val io = IO( new ALUIO)
val sum = io.in_A + Mux(io.alu_Op(0) , -io.in_B , io.in_B)
val cmp = Mux(io.in_A(WLEN-1) === io.in_B(WLEN-1) , sum(WLEN-1) , Mux(io.alu_Op(1) , io.in_B(WLEN-1) , io.in_A(WLEN-1)))
val shamt = io.in_B(4 ,0).asUInt  // shift amount
val shin = Mux(io.alu_Op(3) , io.in_A , Reverse(io.in_A )) 

// Create variable shin in which use Mux which compares function bits with FN_SR 
//(function shift right) OR FN_SRA (function shift right arithmetic) as Bool parameter if 
//condition satisfies shin_r(shift right) variable will be selected otherwise it will reverse 
//the sequence of shift right variable and select it as Mux result.

val shiftr = (Cat(io.alu_Op(0) && shin(WLEN -1) , shin).asSInt >> shamt)(WLEN -1 , 0)
val shiftl = Reverse(shiftr) 

val out =
Mux ( io.alu_Op === ALU_ADD || io.alu_Op === ALU_SUB , sum ,
Mux ( io.alu_Op === ALU_SLT || io.alu_Op === ALU_SLTU , cmp ,
Mux ( io.alu_Op === ALU_SRA || io.alu_Op === ALU_SRL , shiftr ,
Mux ( io.alu_Op === ALU_SLL , shiftl ,
Mux ( io.alu_Op === ALU_AND , ( io.in_A & io.in_B ) ,
Mux ( io.alu_Op === ALU_OR , ( io.in_A | io.in_B ) ,
Mux ( io.alu_Op === ALU_XOR , ( io.in_A ^ io.in_B ) ,
Mux ( io.alu_Op === ALU_COPY_A , io.in_A ,
Mux ( io.alu_Op === ALU_COPY_B , io.in_B , 0.U )))))))))

io . out := out
io . sum := sum
}