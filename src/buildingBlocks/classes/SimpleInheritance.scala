/**
  * @author Ram Saran Vuppuluri
  *         This simple class contains high level examples for Scala inheritance. Scala does not support multiple
  *         inheritance.
  */
package buildingBlocks.classes

/**
  * This case class is used to define Address structure
  *
  * @param city  City Name
  * @param state State
  */
case class Address(city: String, state: String)

/**
  * This class is parent class for Employee and Client classes.
  *
  * @param name    Name of the person
  * @param address Address of the person
  */
class Person(var name: String, var address: Address) {
  /**
    * Auxiliary constructor with no parameters.
    */
  def this() {
    this(Person.DEFAULT_NAME, Person.DEFAULT_ADDRESS)
  }

  override
  def toString: String = {
    s"$name lives at ${address.city}, ${address.state}"
  }
}

/**
  * This companion object will store constant values used by Person class.
  */
object Person {
  val DEFAULT_NAME = "Dexter Morgan"
  val DEFAULT_ADDRESS = Address.apply("Miami", "FL")
}

/**
  * This is the child class extends from Person class and override default toString implementation to display
  * employee information
  *
  * This class will call auxiliary constructor of the super class.
  *
  * @param designation Designation of the employee
  */
class Employee(designation: String) extends Person {
  override def toString: String = {
    super.toString.concat(s" works with designation $designation")
  }
}

/**
  * * This is the child class extends from Person class and override default toString implementation to display
  * client information.
  *
  * This class will call primary constructor of the super class.
  *
  * @param name    Name of the client
  * @param address Address of the client
  * @param service Service received by client
  */
class Client(name: String, address: Address, service: String) extends Person(name, address) {
  override def toString: String = {
    super.toString.concat(s" receives $service service")
  }
}

object SimpleInheritance {
  def main(args: Array[String]): Unit = {
    val employee = new Employee("Manager")

    println(employee)

    val client = new Client("Pena", Address("New York", "NY"), "Auditing")
    println(client)
  }
}