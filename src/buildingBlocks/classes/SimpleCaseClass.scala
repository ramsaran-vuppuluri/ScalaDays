/**
  * @author   Ram Saran Vuppuluri
  *           This code snippet will demonstrate basic case class functionality. case class are generally used to
  *           define structural data like rows in a table etc and for scenarios where pattern matching is needed.
  *
  *           By default all attributes mentioned in case class are of type val, there by making case classes a good
  *           way to create immutable instances.
  *
  *           When a class is qualified as case class, Scala compiler will generate additional supporting code in the
  *           background:
  *         1. Scala will generate companion object will apply and unapply methods.
  *           1.1. Apply method will generate instance of case class
  *           1.2. Unapply method will cast the instance of case class to Some instance, using unapply scala does
  *           pattern matching.
  *         2. Accessors (getters) are generated for all attributes, additionally mutator is generated for attributes
  *           of var type.
  *         3. Default toString, equals, hashCode, copy and 20 other such methods are generated.
  */
package buildingBlocks.classes

case class Individual(name: String, var age: Int)

object SimpleCaseClassDriver {
  def main(args: Array[String]): Unit = {
    val emily = Individual("Emily", 30)
    val fred = Individual.apply("Fred", 25)

    println(emily)
    println(fred)

    emily.age += 1
    //emily.name = "emily"
    println(emily)
    println(emily == fred)

    emily match {
      case indv: Individual => println(s"$indv is of type Individual")
      case _ => println(s"Current pattern is not of type Individual")
    }

    println(Individual.unapply(emily))
  }
}