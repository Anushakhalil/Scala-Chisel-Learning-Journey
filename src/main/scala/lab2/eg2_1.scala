package lab2
import chisel3._
import chisel3.util._

//class eg2_1 extends Module{
//  val io = IO ( new Bundle {
//    val in0 = Input ( UInt(32.W ) )
//    val in1 = Input ( UInt(32.W ) )
//    val in2 = Input ( UInt(32.W ) )
//    val in3 = Input ( UInt(32.W ) )
//    val sel = Input ( UInt(4.W ) )
//    val out = Output ( UInt(32.W ) )
//  })
//  io.out := Mux1H( io.sel , Seq( io.in0 , io.in1 , io.in2 , io.in3 ))
//  println(( new chisel3.stage.ChiselStage ).emitVerilog( new eg2_1 ()))
//}


class eg2_1 extends Module{
  val io = IO ( new Bundle {
    val in0 = Input ( Bool () )
    val in1 = Input ( Bool () )
    val in2 = Input ( Bool () )
    val in3 = Input ( Bool () )
    val in4 = Input ( Bool () )
    val in5 = Input ( Bool () )
    val in6 = Input ( Bool () )
    val in7 = Input ( Bool () )
    val sel = Input ( UInt (3.W ) )
    val out = Output ( Bool () )
  })
    io . out := MuxLookup ( io.sel , false.B , Array (
    (0.U ) -> io.in0 ,
    (1.U ) -> io.in1 ,
    (2.U ) -> io.in2 ,
    (3.U ) -> io.in3 ,
    (4.U ) -> io.in4 ,
    (5.U ) -> io.in5 ,
    (6.U ) -> io.in6 ,
    (7.U ) -> io.in7 )
    )
  }

//
//class eg2_1 extends Module{
//  val io = IO(new Bundle {
//    val data = Input(UInt(8.W))
//    val anyOne = Output(UInt())
//    val allOnes = Output(UInt())
//    val parityCheck = Output(UInt())
//  })
//  io.allOnes := io.data.andR // 0
//  io.anyOne := io.data.orR // 1
//  io.parityCheck := io.data.xorR // 0
//
//}
//
