package buildingBlocks.controlStructures

import scala.annotation.switch

case class Person(firstName: String)

case class Dog(name: String)

object MatchPatternDriver {
  def main(args: Array[String]): Unit = {
    println(getMonth(1000))

    println(getClassAsString(10))

    println(getOddEven(8))
    println(getOddEven(80))
    println(getOddEven(-10))

    // trigger the constant patterns
    println(echoWhatYouGaveMe(0))
    println(echoWhatYouGaveMe(true))
    println(echoWhatYouGaveMe("hello"))
    println(echoWhatYouGaveMe(Nil))

    // trigger the sequence patterns
    println(echoWhatYouGaveMe(List(0, 1, 2)))
    println(echoWhatYouGaveMe(List(1, 2)))
    println(echoWhatYouGaveMe(List(1, 2, 3)))
    println(echoWhatYouGaveMe(Vector(1, 2, 3)))

    // trigger the tuple patterns
    println(echoWhatYouGaveMe((1, 2)))
    println(echoWhatYouGaveMe((1, 2, 3)))

    // trigger the constructor patterns
    println(echoWhatYouGaveMe(Person("Alexander")))
    println(echoWhatYouGaveMe(Dog("Ghost")))

    // trigger the typed patterns
    println(echoWhatYouGaveMe("Hello, world"))
    println(echoWhatYouGaveMe(42))
    println(echoWhatYouGaveMe(42F))
    println(echoWhatYouGaveMe(Array(1, 2, 3)))
    println(echoWhatYouGaveMe(Array("coffee", "apple pie")))
    println(echoWhatYouGaveMe(Dog("Fido")))
    println(echoWhatYouGaveMe(List("apple", "banana")))
    println(echoWhatYouGaveMe(Map(1 -> "Al", 2 -> "Alexander")))

    // trigger the wildcard pattern
    println(echoWhatYouGaveMe("33d"))

    //excpetion pattern
    toInt("100")
  }

  def getMonth(month: Int): String = (month: @switch) match {
    case 1 => "January"
    case 2 => "February"
    case 3 => "March"
    case 4 => "April"
    case 5 => "May"
    case 6 => "June"
    case 7 => "July"
    case 8 => "August"
    case 9 => "September"
    case 10 => "October"
    case 11 => "November"
    case 12 => "December"
    case _ => "Invalid month"
  }

  def getClassAsString(input: Any): String = input match {
    case s: String => "String"
    case i: Int => "Int"
    case f: Float => "Float"
    case l: Long => "Long"
    case default => "Unknown"
  }

  def getOddEven(intIn: Int): String = {
    intIn match {
      case 1 | 3 | 5 | 7 | 9 => "Odd"
      case 2 | 4 | 6 | 8 | 10 => "Even"
      case _ =>
        if (intIn > 10) {
          intIn + "> 10"
        } else {
          intIn + "< 0"
        }
    }
  }

  def echoWhatYouGaveMe(x: Any): String = {
    x match {
      // constants patterns
      case 0 => "zero"
      case true => "true"
      case "hello" => "you said hello"
      case Nil => "an empty list"

      // sequence patterns
      case List(0, _, _) => "a three-element list with 0 as the first element"
      case List(1, _*) => "a list beginning with 1, having any number of elements"
      case Vector(1, _*) => "a Vector beginning with 1, having any number of elements"

      // tuples
      case (a, b) => s"got $a and $b"
      case (a, b, c) => s"got $a, $b and $c"

      // constructor patterns
      case Person(firstName) => s"Person object with $firstName received"
      case Dog(name) => s"Dog with $name received"

      //typed pattern
      case s: String => "String"
      case i: Int => "Int"
      case f: Float => "Float"
      case l: Long => "Long"
      case ia: Array[Int] => "Int array"
      case sa: Array[String] => "String array"
      case d: Dog => s"Dog with ${d.name} received"
      case m: Map[_, _] => m.toString

      case _ => "unknown"
    }
  }

  @throws(classOf[NumberFormatException])
  def toInt(string: String): Option[Int] = {
    try {
      Some(string.toInt)
    } catch {
      case e: NumberFormatException => throw e
    }
  }
}