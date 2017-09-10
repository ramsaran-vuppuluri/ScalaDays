/**
  * @author Ram Saran Vuppuluri.
  *
  *         This object contains basic data types and functions that can be performed in Scala.
  *
  *         Following are the Scala's numeric types
  *
  *         1. Char - 16 bit
  *         2. Byte - 8 bit signed
  *         3. Short - 16 bit signed
  *         4. Int - 32 bit signed
  *         5. Long - 64 bit signed
  *         6. Float - 32 bit (754 single precision float)
  *         7. Double  - 64 bit (754 single precision float)
  */

package buildingBlocks

import java.text.NumberFormat
import java.util.Locale

import scala.util.Random

object DataTypeDriver {
  def main(args: Array[String]): Unit = {
    /*
    Minimum and Maximum values of Char type
     */
    println("Char Minimum value: " + Char.MinValue)
    println("Char Maximum value: " + Char.MaxValue)

    /*
    Minimum and Maximum values of numeric types
     */
    println("Byte Minimum value: " + Byte.MinValue)
    println("Byte Maximum value: " + Byte.MaxValue)

    println("Short Minimum value: " + Short.MinValue)
    println("Short Maximum value: " + Short.MaxValue)

    println("Int Minimum value: " + Int.MinValue)
    println("Int Maximum value: " + Int.MaxValue)

    println("Long Minimum value: " + Long.MinValue)
    println("Long Maximum value: " + Long.MaxValue)

    println("Float Minimum value: " + Float.MinValue)
    println("Float Minimum Positive value: " + Float.MinPositiveValue)
    println("Float  Maximum value: " + Float.MaxValue)

    println("Double Minimum value: " + Double.MinValue)
    println("Double Minimum Positive value: " + Double.MinPositiveValue)
    println("Double Maximum value: " + Double.MaxValue)

    /*
    Parsing string to number
     */
    try {
      println("100".toByte)
      println("100".toShort)
      println("100".toInt)
      println("100".toLong)
      println("100".toFloat)
      println("100".toDouble)
    } catch {
      case e: NumberFormatException => println("Cannot covert non numeric value into numeric value")
    }

    /*
    Converting between one type to other
     */
    if (19.45.isValidInt) println(19.45.toInt)
    println(19.toFloat)
    println(19.toDouble)
    println(19.toLong)

    /*
    Overriding default numeric type
     */
    var a: Double = 100
    println(a)
    val b: Int = 0
    println(b)
    val c: Short = 0
    println(c)

    /*
    Numeric operations
     */
    a = 1
    a += 1
    println(a)
    a -= 1
    println(a)
    a *= 2
    println(a)
    a /= 2
    println(a)

    /*
    Double comparision with precession.
     */
    val double1: Double = 0.3
    val double2: Double = 0.1 + 0.2
    val precession: Double = 0.0001
    println(double1)
    println(double2)
    println(double1 == double2)
    println(doubleEqualsWithInPrecession(double1, double2, precession))

    /*
    BigInt
     */
    var bigInt = BigInt(1234567890)
    bigInt += 1
    println(bigInt)
    bigInt -= 1
    println(bigInt)
    bigInt *= 2
    println(bigInt)
    bigInt /= 2
    println(bigInt)

    /*
    BigDecimal
     */
    var bigDecimal = BigDecimal(1234567890)
    bigDecimal += 1
    println(bigDecimal)
    bigDecimal -= 1
    println(bigDecimal)
    bigDecimal *= 2
    println(bigDecimal)
    bigDecimal /= 2
    println(bigDecimal)

    /*
    Random generator
     */
    val random: Random = new Random()
    println(random.nextPrintableChar())
    println(random.nextBoolean())
    println(random.nextInt())
    println(random.nextInt(10))
    println(random.nextLong())
    println(random.nextString(10))
    println(random.nextFloat())
    println(random.nextDouble())

    /*
    Range
     */
    val range: Seq[Int] = 1 to random.nextInt(10)
    println(range)
    println(range.toList)
    range.toArray.foreach(println)

    /*
    Number formatting
     */
    val pi = math.Pi
    println(pi)
    println(f"$pi%1.5f")
    println(f"$pi%06.2f")

    var formatter = NumberFormat.getIntegerInstance
    val locale: Locale = new Locale("de", "DE")

    println(formatter.format(1000000))

    formatter = NumberFormat.getIntegerInstance(locale)

    println(formatter.format(1000000))

    formatter = NumberFormat.getCurrencyInstance()

    println(formatter.format(1000000))

    formatter = NumberFormat.getCurrencyInstance(locale)

    println(formatter.format(1000000))

  }

  def doubleEqualsWithInPrecession(x: Double, y: Double, precision: Double): Boolean = {
    if ((x - y).abs < precision) {
      true
    } else {
      false
    }

  }
}