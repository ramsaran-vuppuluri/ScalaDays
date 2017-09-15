/**
  * @author Ram Saran Vuppuluri
  *         This class contains sample demonstration of private vs private[this] concepts of Scala.
  *         1. private in Scala is different from Java private. In scala if an attribute is declared private is
  *         accessible by all instances of the class.
  *         2. In scala if an attribute is declared as private[this] it is only accessible only by current instance
  *         of the class. This is same as Java private.
  */
package buildingBlocks.classes

class SimplePrivate {
  private var age: Int = _

  def setAge(ageIn: Int): Unit = {
    age = ageIn
  }

  def isOlder(that: SimplePrivate): Boolean = {
    this.age > that.age
  }
}

class SimpleThisPrivate {
  private[this] var age: Int = _

  def setAge(ageIn: Int): Unit = {
    age = ageIn
  }

  def isOlder(that: SimplePrivate): Unit = {
    /**
      * Uncommenting below lines will cause compilation problems as age is declared as private{this] age value of
      * 'that' instance is not accessible by 'this' instance.
      */
    /*
    this.age > that.age
    */
  }
}

object SimplePrivateDriver {
  def main(args: Array[String]): Unit = {
    val simplePrivate1 = new SimplePrivate
    simplePrivate1.setAge(10)
    val simplePrivate2 = new SimplePrivate
    simplePrivate2.setAge(20)
    println(simplePrivate1.isOlder(simplePrivate2))
    println(simplePrivate2.isOlder(simplePrivate1))
  }
}