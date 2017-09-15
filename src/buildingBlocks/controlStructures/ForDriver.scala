package buildingBlocks.controlStructures

object ForDriver {
  def main(args: Array[String]): Unit = {
    var array = Array("apple", "banana", "orange")

    /*
    Basic for loop structure
     */
    for (ele <- array) {
      println(ele.capitalize)
    }

    /*
     Basic for-yield structure. for-yield will always yield same data type of input collection i.e. if we are processing array array will be returned, same way if it is vector  vector will be returned.
     */
    val capitalizeArray: Array[String] = for (ele <- array) yield ele.capitalize
    capitalizeArray.foreach(println)

    /*
    Zip with Index on an collection return tuple of element and index.
     */
    array.zipWithIndex.foreach(println)

    for ((ele, index) <- array.zipWithIndex) {
      println(s"Element: ${ele.capitalize} Index: $index")
    }

    /*
    Guard condition on a for loop
     */

    for (i <- 0 to 10 if i < 4) println(i)

    for {
      i <- 0 to 10
      if i < 4
    } println(i)

    for {
      i <- 1 to 10
      if i > 3 && i < 6 && i % 2 == 0
    } println(i)

    /*
    Looping over Map
     */
    val map = Map("fName" -> "Robert", "lName" -> "Goren")
    for {
      (key, value) <- map
    } println(s"Key: $key Value: $value")

    /*
    For loop with multiple counters
     */
    for {
      i <- 1 to 2
      j <- 1 to 2
    } println(s"$i $j")

    for {
      i <- 1 to 2
      j <- 1 to 2
      k <- 1 to 2
    } println(s"$i $j $k")
  }
}