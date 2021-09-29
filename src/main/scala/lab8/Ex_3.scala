package lab8
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source

trait Config{
    val WLEN = 32
    val INST_MEM_LEN = 32
    val string = "/home/anusha/Scala-Chisel-Learning-Journey/src/main/scala/lab8/file.txt"
}

class InstMemIO extends Bundle with Config {
    val addr = Input(UInt(WLEN.W))
    val inst = Output(UInt(WLEN.W))
}

class Ex_3 extends Module with Config {
    val io = IO ( new InstMemIO )
    // INST_MEM_LEN in Bytes or INST_MEM_LEN / 4 in words
    val imem = Mem(INST_MEM_LEN, UInt( WLEN.W ))
    loadMemoryFromFile(imem , string)
    io.inst := imem(io.addr)


}