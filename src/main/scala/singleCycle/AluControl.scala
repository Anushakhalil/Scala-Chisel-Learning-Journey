package singleCycle
import chisel3._ 
import chisel3.util._

class AluControl extends Module with Config{
    val io = IO(new Bundle{
        val func3inAC = Input(TYPE(FUNC_3.W))
        val func7inAC = Input(TYPE(1.W))
        val opcFromControl = Input(TYPE(3.W))
        val aluControl = Output(TYPE(4.W))
    })
    
    io.aluControl := 0.U
    val lst1 = io.opcFromControl.asBools.toList
    val lst2 = io.func3inAC.asBools.toList

    val firstor = ~lst1(2) & ~lst1(0) & ~lst2(2) & lst2(1) | lst1(1) & lst1(2) 
    val secondor = ~lst2(1) & lst2(0) | ~lst2(1) & lst2(2) | lst1(1) & lst1(2)
    val thirdor = ~lst2(1) & ~lst2(2) & lst2(0) | ~lst2(1) & lst2(0) & io.func7inAC | ~lst1(1) & lst2(2) & lst2(1) & io.func7inAC | 
    ~lst1(2) & lst2(2) & lst2(1) | ~lst1(0) & lst2(1) & lst2(2) | lst2(2) & lst2(1) & ~io.func7inAC | lst1(0) & lst2(2) & ~lst2(0) & io.func7inAC | lst1(2) & lst2(0)
    val fourthor = ~lst1(2) & ~lst1(1) & ~lst1(0) & ~lst2(2) & io.func7inAC | ~lst1(1) & ~lst2(2) & ~lst2(1) & 
    io.func7inAC | ~lst2(2) & lst2(0) | ~lst2(1) & lst2(0) & ~io.func7inAC | lst2(2) & lst2(1) & ~lst2(0) | 
    lst1(1) & lst1(0) & ~lst2(2) & lst2(1) & io.func7inAC | lst1(2) & lst1(0) & ~lst2(2) & io.func7inAC | 
    lst1(2) & lst1(1) & ~lst2(2) & io.func7inAC | lst1(0) & lst1(1) & lst1(2)
    
    io.aluControl := Cat(firstor,secondor,thirdor,fourthor)

}