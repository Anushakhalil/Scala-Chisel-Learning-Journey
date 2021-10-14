package singleCycle
import org.scalatest._ 
import chisel3._
import chiseltest._

class controlDecodeTest extends FreeSpec with ChiselScalatestTester{
    "Control Decode Test" in {
        test(new controlDecode){c => 
            // inputs
            c.io.Rformat.poke(0.B)
            c.io.Load.poke(0.B)
            c.io.Store.poke(0.B)
            c.io.Branch.poke(0.B)
            c.io.Bnew.poke(0.B)
            c.io.Itype.poke(0.B)
            c.io.Jalr.poke(0.B)
            c.io.Jal.poke(0.B)
            c.io.Lui.poke(0.B)
            c.io.Auipc.poke(1.B)

            c.clock.step(1)

            // outputs
            c.io.MemWrite.expect(0.B)
            c.io.AluOp.expect(5.U) // will be 7 when all pins off
            c.io.MemRead.expect(0.B)
            c.io.RegFile.expect(1.B)
            c.io.MemToReg.expect(0.B)
            c.io.AluOper.expect(0.B)
            c.io.OperA_sel.expect(1.U)
            c.io.OperB_sel.expect(1.B)
            c.io.Imm_sel.expect(2.U)
            c.io.NextPc_sel.expect(0.U)
            c.io.Jalr_pin.expect(0.B) 
            
        }
    }
}	