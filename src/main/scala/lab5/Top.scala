package lab5
import chisel3._
import chisel3.stage.ChiselStage

class Adder_Input(x: Int, y: Int) extends Bundle{
    val in1 = UInt(x.W)  // 18
    val in2 = UInt(y.W) // 30

    // creating custom cloneType
    override def cloneType = (new Adder_Input(x,y)).asInstanceOf[this.type]

}
class AdderCustomclonetype(inBundle : Adder_Input, outsize: Int) extends Module{   // obj(18,20)  32
    val io = IO(new Bundle{
        val out = Output(UInt(outsize.W))  // 30

        // chiselTypeOf returns chisel type 
        val in_Bundle = Input(chiselTypeOf(inBundle))    
    })
    io.out := io.in_Bundle.in1 + io.in_Bundle.in2
}
class Top(in1size: Int, in2size: Int,outsize : Int) extends Module{  // 18 30 32

    val io = IO(new Bundle {
        val out = Output(UInt(outsize.W))   //  -> 32 bit
        val in = Input(UInt(in1size.W))    // 5 -> 18 bit
    })

    // input bundle instance
    val inBundle = Wire( new Adder_Input(in1size, in2size))   //18, 30
    inBundle := DontCare // DontCare islye ky hum ne sir type define ki ha

    // module instance
    val m = Module( new AdderCustomclonetype(inBundle, outsize)) 
    m.io.in_Bundle.in1 := io.in
    m.io.in_Bundle.in2 := io.in
    io.out := m.io.out

}