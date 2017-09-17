/**
  * @author Ram Saran Vuppuluri
  *         This code snippet will demonstrate basic abstract class and trait functionality. Both abstract classes
  *         and traits contain concrete and abstract members and function.
  *
  *         There are couple of main differences between abstract class and trait:
  *         1. Abstract class contains constructor while trait does not have constructor
  *         2. A class can extend only 1 abstract class but n number of traits
  */
package buildingBlocks.classes

trait Animal {
  var numberOfLegs: Option[Int]
}

trait Trait1 {

}

trait Trait2 {

}

abstract class Pet(name: String) extends Animal {
  val greeting: Option[String]

  var age: Option[Int]

  def sayHello {
    println(greeting)
  }

  override def toString: String = {
    s"I say ${greeting.getOrElse("")} and of age ${age.getOrElse(0)} walks on ${numberOfLegs.getOrElse(0)} legs"
  }
}

class Dog(name: String) extends Pet(name) with Trait1 with Trait2 {
  override val greeting: Option[String] = Some("Woof")
  override var age: Option[Int] = Some(2)
  override var numberOfLegs: Option[Int] = Some(4)
}

class Cat(name: String) extends Pet(name) {
  override val greeting: Option[String] = Some("Meow")
  override var age: Option[Int] = Some(5)
  override var numberOfLegs: Option[Int] = Some(4)
}

object SimpleAbstractClassDriver {
  def main(args: Array[String]): Unit = {
    val dog = new Dog("Ghost")
    val cat = new Cat("Rupert")

    dog.sayHello
    cat.sayHello
    println(cat)
    println(dog)

    cat.age = None
    println(cat)
  }
}