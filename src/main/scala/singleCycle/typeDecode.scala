package singleCycle
import chisel3._ 
import chisel3.util._

object typedecode{
    val R = "b0110011"
    val Lw = "b0000011"
    val Sw = "b0100011"
    val B = "b1100011"
    val I = "b0010011"
    val JALR = "b1100111"
    val J = "b1101111"
    val LUI = "b0110111"
    val AUIPC = "b0010111"
}

import typedecode._
class typeDecode extends Module with Config{
    	val io= IO(new Bundle{
            val Opcode= Input(TYPE(OPCODE.W))
            val Rtype= Output(Bool())
            val Itype= Output(Bool())
            val Branch= Output(Bool())
            val Load= Output(Bool())
            val Store= Output(Bool())
            val Jal= Output(Bool())
            val Jalr= Output(Bool())
            val Lui= Output(Bool())
            val Auipc = Output(Bool())
	})

    List(io.Rtype,io.Itype,io.Branch,io.Load,io.Store,io.Jal,io.Jalr,io.Lui,io.Auipc).map(_ := 0.B)

    switch(io.Opcode){
        is(R.U){
        io.Rtype := 1.B

        }
        is(Lw.U){
        io.Load := 1.B

        } 
        is(Sw.U){
        io.Store := 1.B

        } 
        is(B.U){
        io.Branch := 1.B

        } 
        is(I.U){
        io.Itype := 1.B

        } 
        is(JALR.U){
        io.Jalr := 1.B

        } 
        is(J.U){
        io.Jal := 1.B

        }
        is(LUI.U){
        io.Lui := 1.B

        }
        is(AUIPC.U){
        io.Auipc := 1.B
        
        }
    }
}