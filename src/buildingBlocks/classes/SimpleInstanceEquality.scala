/**
  * @author Ram Saran Vuppuluri
  *         This is one of the many possible implementation of equality in Scala
  */
package buildingBlocks.classes

class Human(name: String, age: Int) {
  def canEqual(that: Any): Boolean = {
    that.isInstanceOf[Human]
  }

  override def hashCode(): Int = {
    val prime = 31
    var result = 1
    result = prime * result + (if (age != null) age else 0)
    result = prime * result + (if (name != null) name.hashCode else 0)
    result
  }

  override def equals(that: scala.Any): Boolean = {
    this.canEqual(that) && this.hashCode() == that.hashCode()
  }
}

object SimpleInstanceEqualityDriver {
  def main(args: Array[String]): Unit = {
    val nimoy = new Human("Leonard Nimoy", 82)
    val nimoy2 = new Human("Leonard Nimoy", 82)
    val shatner = new Human("William Shatner", 82)
    val ed = new Human("Ed " + "Chigliak", 20)

    println(s"nimoy == nimoy: ${nimoy == nimoy}")
    println(s"nimoy == nimoy2: ${nimoy == nimoy2}")
    println(s"nimoy2 == nimoy: ${nimoy2 == nimoy}")
    println(s"nimoy != shatner: ${nimoy != shatner}")
    println(s"shatner != nimoy: ${shatner != nimoy}")
    println(s"nimoy != null: ${nimoy != null}")
    println(s"nimoy != ed: ${nimoy != ed}")

  }
}
