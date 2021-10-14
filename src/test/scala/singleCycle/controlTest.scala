package singleCycle
import org.scalatest._ 
import chisel3._
import chiseltest._

class controlTest extends FreeSpec with ChiselScalatestTester{
    "Control Test" in {
        test(new control){c => 
            // inputs
            c.io.Opcode.poke("b1101111".U)
            c.io.Bnew.poke(1.B)

            c.clock.step(1)

            // outputs
            c.io.MemWrite.expect(0.B)
            c.io.AluOp.expect(3.U) 
            c.io.MemRead.expect(0.B)
            c.io.RegFile.expect(1.B)
            c.io.MemToReg.expect(0.B)
            c.io.AluOper.expect(0.B)
            c.io.OperA_sel.expect(2.U)
            c.io.OperB_sel.expect(0.B)
            c.io.Imm_sel.expect(3.U)
            c.io.NextPc_sel.expect(2.U)
            c.io.Jalr_pin.expect(0.B) 
            
        }
    }
}	