package buildingBlocks.controlStructures

import scala.util.control.Breaks._

object BreakContinueDriver extends App {
  println("== Break Example ==")

  breakable {
    for (i <- 1 to 10) {
      println(i)
      if (i > 4) break()
    }
  }

  println("== Continue Example ==")
  val searchMe = "peter piper picked a peck of pickled peppers"
  var numPs = 0
  for (char <- searchMe) {
    breakable {
      if (char == 'p') numPs += 1
      else break()
    }
  }

  println(s"Found $numPs of 'p' chars in $searchMe")
}