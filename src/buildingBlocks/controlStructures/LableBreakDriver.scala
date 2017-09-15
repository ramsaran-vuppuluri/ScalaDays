package buildingBlocks.controlStructures

import scala.util.control.Breaks

object LableBreakDriver {
  def main(args: Array[String]): Unit = {
    val inner = new Breaks
    val outter = new Breaks

    outter.breakable {
      for (i <- 1 to 5) {
        inner.breakable {
          for (j <- 'a' to 'e') {
            if (i == 1 && j == 'c') inner.break else println(s"i: $i j: $j")
            if (i == 2 && j == 'b') outter.break
          }
        }
      }
    }
  }
}