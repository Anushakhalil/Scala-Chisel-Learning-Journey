package lab2
import org.scalatest._
import chiseltest._
import chisel3._

class Task2Test extends FreeSpec with ChiselScalatestTester{
  "Task 2 Test" in {
    test(new Task2()){ c =>
      c.io.in(0).poke(true.B)
      c.io.in(1).poke(true.B)
      c.io.in(2).poke(false.B)
      c.io.in(3).poke(true.B)
      c.io.sel(0).poke(false.B)
      c.io.sel(1).poke(true.B)
      c.io.shift_type.poke(true.B)
      c.clock.step(20)
//      c.io.out(1).expect(true.B)
//      c.io.out(1).expect(false.B)
//      c.io.out(2).expect(true.B)
//      c.io.out(3).expect(false.B)
    }
  }

  "Task 2_1 Test" in {
    test(new Task2()){ c =>
      c.io.in(0).poke(false.B)
      c.io.in(1).poke(true.B)
      c.io.in(2).poke(true.B)
      c.io.in(3).poke(false.B)
      c.io.sel(0).poke(true.B)
      c.io.sel(1).poke(true.B)
      c.io.shift_type.poke(true.B)
      c.clock.step(20)
      //      c.io.out(1).expect(true.B)
      //      c.io.out(1).expect(false.B)
      //      c.io.out(2).expect(true.B)
      //      c.io.out(3).expect(false.B)
    }
  }

  "Task 2_2 Test" in {
    test(new Task2()){ c =>
      c.io.in(0).poke(true.B)
      c.io.in(1).poke(false.B)
      c.io.in(2).poke(false.B)
      c.io.in(3).poke(true.B)
      c.io.sel(0).poke(false.B)
      c.io.sel(1).poke(false.B)
      c.io.shift_type.poke(true.B)
      c.clock.step(20)
      //      c.io.out(1).expect(true.B)
      //      c.io.out(1).expect(false.B)
      //      c.io.out(2).expect(true.B)
      //      c.io.out(3).expect(false.B)
    }
  }

  "Task 2_3 Test" in {
    test(new Task2()){ c =>
      c.io.in(0).poke(false.B)
      c.io.in(1).poke(false.B)
      c.io.in(2).poke(false.B)
      c.io.in(3).poke(true.B)
      c.io.sel(0).poke(true.B)
      c.io.sel(1).poke(false.B)
      c.io.shift_type.poke(true.B)
      c.clock.step(20)
      //      c.io.out(1).expect(true.B)
      //      c.io.out(1).expect(false.B)
      //      c.io.out(2).expect(true.B)
      //      c.io.out(3).expect(false.B)
    }
  }
}
