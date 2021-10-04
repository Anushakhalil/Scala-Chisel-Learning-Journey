package fp
import chisel3._ 
import chisel3.util._ 
import chisel3.experimental.{BaseModule}

trait ModuleIO{
    def in1 : UInt
    def in2 : UInt
    def output : UInt
}

class Add extends RawModule with ModuleIO {
    val in1 = IO(Input(UInt(8.W)))
    val in2 = IO(Input(UInt(8.W)))
    val output = IO(Output(UInt(8.W)))
    output := in1 + in2
}

class Sub extends RawModule with ModuleIO {
    val in1 = IO(Input(UInt(8.W)))
    val in2 = IO(Input(UInt(8.W)))
    val output = IO(Output(UInt(8.W)))
    output := in1 - in2
}

class Ex[T <: BaseModule with ModuleIO] (param1: => T, param2: => T) extends Module{
    val io = IO(new Bundle{
        val in1 = Input(UInt(8.W))
        val in2 = Input(UInt(8.W))
        val out1 = Output(UInt(8.W))
        val out2 = Output(UInt(8.W))
    })

    val subModule1 = Module(param1)
    val subModule2 = Module(param2)

    subModule1.in1 := io.in1
    subModule1.in2 := io.in2
    io.out1 := subModule1.output

    subModule2.in1 := io.in1
    subModule2.in2 := io.in2
    io.out2 := subModule2.output
}