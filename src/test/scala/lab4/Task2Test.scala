package lab4

import chisel3._
import org.scalatest._
import chisel3.util._
import chiseltest._

import scala.util.Random
import value._

class Task2Test extends FreeSpec with ChiselScalatestTester{
    "Immediate Generation Test" in {
        test( new Task2){c => 

        val array_op = Array("h0040066f")
        // val array_op = Array("h00200513", "h00a02023", "h00020537" , "h0040066f","h00b50263")

        for (i <- 0 until 1){
        val opr = Random.nextInt(1)
        val valuee = array_op(opr)

        val result = valuee match {
        case "h00200513" => 2 //I
        case "h00a02023" => 0 //S
        case "h00200593" => 2 //U
        case "h0040066f" => 20 //J
        case "h00b50263" => 8  //B
        case  _ => 0

            }
        println("v",valuee)

        c.io.instr.poke(valuee.U)
        c.clock.step(1)
        c.io.immd_se.expect(result.U)
        }
        c.clock.step(2)
        }
    }

}