package example
import chisel3._

class fourToOneMux extends Module{
  val io = IO (new Bundle{
    val a= Input(UInt(1.W))
    val b= Input(UInt(1.W))
    val c= Input(UInt(1.W))
    val d= Input(UInt(1.W))
    val sel0= Input(UInt(1.W))
    val sel1= Input(UInt(1.W))
    val out= Output(UInt(1.W))
  })
  when(io.sel0 === 0.U & io.sel1 === 0.U){
    io.out := io.a
  }.elsewhen(io.sel0 === 0.U & io.sel1 === 1.U){
    io.out := io.b
  }.elsewhen(io.sel0 === 1.U & io.sel1 === 0.U){
    io.out := io.c
  }.elsewhen(io.sel0 === 1.U & io.sel1 === 1.U){
    io.out := io.d
  }.otherwise{
    io.out := DontCare
  }
}