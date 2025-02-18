package lab6
import chisel3._ 
import chisel3.util._

class PWM ( val max : Int = 3 ,val duty_cycle : Int = 1) extends Module {
    val io = IO ( new Bundle {
        val out = Output ( Bool () )
    })
    
    val counter = RegInit(0.U(log2Ceil( max ).W ))
    counter := Mux( counter === max.U , 0.U , counter + 1.U )
    io.out := duty_cycle.U > counter
}