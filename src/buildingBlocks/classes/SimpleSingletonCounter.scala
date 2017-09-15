/**
  * @author Ram Saran Vuppuluri
  *         This simple class explains how to create singletons in Scala
  */
package buildingBlocks.classes

/**
  * To build a Singleton class we need to declare primary constructor of class as private, by doing this the access
  * for the constructor is only available to companion object.
  *
  * @param seedCount Initial seed value passed by companion object
  */
class SimpleSingletonCounter private(var seedCount: Int = 0) {
  override
  def toString: String = {
    s"Current count: $seedCount"
  }
}

/**
  * Companion object for SimpleSingletonCounter class. This object will invoke default constructor and exposes the
  * instance to calling functions via getInstance pattern.
  */
object SimpleSingletonCounter {
  val simpleSingletonCounter = new SimpleSingletonCounter

  def getSimpleSingletonCounterInstance: SimpleSingletonCounter = simpleSingletonCounter
}

object SimpleSingletonCounterDriver {
  def main(args: Array[String]): Unit = {
    val simpleSingletonCounter1 = SimpleSingletonCounter.getSimpleSingletonCounterInstance
    println(simpleSingletonCounter1)
    simpleSingletonCounter1.seedCount += 1

    val simpleSingletonCounter2 = SimpleSingletonCounter.getSimpleSingletonCounterInstance
    println(simpleSingletonCounter2)

    /**
      * Uncommenting below lines will not compile code as we cannot directly invoke constructor of a singleton class.
      */
    /*
    val simpleSingletonCounter3 = new SimpleSingletonCounter();
    println(simpleSingletonCounter3)
    */
  }
}