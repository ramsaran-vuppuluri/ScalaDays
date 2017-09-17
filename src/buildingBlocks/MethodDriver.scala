/**
  * @author Ram Saran Vuppuluri
  *         This code snippet will demonstrate basic operations that can be performed on Scala methods
  */
package buildingBlocks

import java.io.IOException

trait Human {
  def hello = "the Human trait"
}

trait Mother extends Human {
  override def hello: String = "the Mother trait"
}

trait Father extends Human {
  override def hello: String = "the Father trait"
}

trait Cousin extends Human {
  override def hello: String = "the Cousin trait"
}

class Child extends Human with Mother with Father {
  /**
    * This will call the hello method in Father trait, by not mentioning the trait, the call will be always made to
    * immediate super class which in this case if Father.
    */
  def printSuper = println(super.hello)

  /**
    * This will call the hello method in Mother trait
    */
  def printSuperMother = println(super[Mother].hello)

  /**
    * This will call the hello method in Father trait
    */
  def printSuperFather = println(super[Father].hello)

  /**
    * This will call the hello method in Human trait
    */
  def printSuperHuman = println(super[Human].hello)

  /**
    * This will give compilation error as Child class is not inheriting from Cousin trait.
    */
  /*
  def printSuperCousin = println(super[Cousin].hello)
  */
}

class Connection {
  /**
    * This method will show how to assign default values to the method parameters if no value is passed default value
    * will be used.
    *
    * @param timeOut  connection timeout value, with default value of 5000 milli seconds
    * @param protocol connection protocol value, with default value as http protocol.
    */
  def makeConnection(timeOut: Int = 5000, protocol: String = "http") {
    println(s"Connection is made using $protocol Protocol with time out $timeOut milli seconds")
  }

  /**
    * This method will demonstrate that parameters with default value should always be given at the end. Even though
    * the method can be declared with non default values at the end, it will cause compilation error during
    * invocation.
    *
    * @param protocol   connection protocol value, with default value as SFTP protocol.
    * @param remotePath remote file path value
    */
  def getFile(protocol: String = "SFTP", remotePath: String): Unit = {
    println(s"Transferring file from $remotePath using $protocol Protocol")
  }

  /**
    * This method will show how to declare exceptions that will be thrown by a method.
    *
    * @throws IOException Java IO Exception
    */
  @throws[IOException]
  def getFile: Unit = {
    throw new IOException()
  }
}

class Stocks {
  /**
    * This method will return Tuple value
    *
    * @return Tuple value with stock symbol, stock current price and stock bid price.
    */
  def getStockInfo = {
    ("NFLX", 100.00, 101.00)
  }

  /**
    * This method demonstrate how to declare a method that takes variable number arguments. There are three rules
    * for using variable arguments as parameters.
    * 1. all the variable arguments should be of same data type
    * 2. variable arguments parameter should be always declared as last parameter
    * 3. there can be always 1 variable arguments parameter.
    *
    * @param strings variable number of string instances
    */
  def printAll(strings: String*): Unit = {
    strings.foreach(println)
  }

  /**
    * This method demonstrate how to declare a method that takes variable number arguments. There are three rules
    * for using variable arguments as parameters.
    * 1. all the variable arguments should be of same data type
    * 2. variable arguments parameter should be always declared as last parameter
    * 3. there can be always 1 variable arguments parameter.
    *
    * This method compilation will fail as its not satisfying rule #2
    *
    */
  /*def printAllWithSize(strings: String*, size: Int)={
    println(size)
    strings.foreach(println)
  }*/

  /**
    * This method demonstrate how to declare a method that takes variable number arguments. There are three rules
    * for using variable arguments as parameters.
    * 1. all the variable arguments should be of same data type
    * 2. variable arguments parameter should be always declared as last parameter
    * 3. there can be always 1 variable arguments parameter.
    *
    * @param strings variable number of string instances
    */
  def printAllWithSize(size: Int, strings: String*) = {
    println(size)
    strings.foreach(println)
  }
}

/**
  * This class will show how to declare methods to set values in Flute style of coding
  *
  * method should return "this" to be compliant with flute style of coding
  */
class Pizza {
  private var crustSize = 0
  private var crustType = ""
  private val toppings: util.ArrayList[String] = new util.ArrayList[String]()

  def addTopping(topping: String) = {
    this.toppings.add(topping)
    this
  }

  def crustType(crustTypeIn: String): this.type = {
    this.crustType = crustTypeIn
    this
  }

  def crustSize(crustSizeIn: Int): this.type = {
    this.crustSize = crustSizeIn
    this
  }

  override def toString: String = s"Your Pizza is of size $crustSize type $crustType with toppings ${
    toppings
      .toString.substring(1, toppings.toString.indexOf("]"))
  }"
}

object MethodDriver {
  def main(args: Array[String]): Unit = {
    val child = new Child
    child.printSuper
    child.printSuperMother
    child.printSuperFather
    child.printSuperHuman

    val connection = new Connection
    /*connection.makeConnection*/
    connection.makeConnection()
    connection.makeConnection(2000)
    connection.makeConnection(2000, "https")
    connection.makeConnection(protocol = "sftp")
    connection.makeConnection(protocol = "sftp", timeOut = 1000)
    /**
      * Uncommenting below line will throw IO Exception.
      */
    /*connection.getFile*/

    /*connection.getFile("/root/")*/

    val stocks = new Stocks

    val (symbol, currentPrice, bidPrice) = stocks.getStockInfo
    println(s"Stock symbol: $symbol Current Price: $currentPrice Bid Price: $bidPrice")
    /**
      * Uncommenting below line will cause compilation issues because when declaring the method parameters are not
      * present for getStockInfo method.
      */
    /*val stockInfo = stocks.getStockInfo()*/
    val stockInfo = stocks.getStockInfo
    println(s"Stock symbol: ${stockInfo._1} Current Price: ${stockInfo._2} Bid Price: ${stockInfo._3}")

    val fruits = List("apple", "banana", "cherry")
    stocks.printAll(fruits: _*)
    stocks.printAllWithSize(fruits.size, fruits: _*)

    /**
      * Flute style of coding
      */
    val pizza = new Pizza
    pizza.crustSize(10).crustType("Thick").addTopping("Onion").addTopping("Tomatoes").addTopping("Pepperoni")
    println(pizza)
  }
}
