/**
  * @author Ram Saran Vuppuluri.
  *
  *         This object contains basic String operations in Scala. Strings in Scala are considered as sequence of characters.
  */
package buildingBlocks

object StringsDriver {
  def main(args: Array[String]): Unit = {

    /*
    String equality operations. == in scala is null safe.
     */
    val string1 = "Hello";
    val string2 = "Hello";
    val string3 = "H" + "ello";
    val string4: String = null;
    println(string1 == string2);
    println(string1 == string3);
    println(string1 == string4);

    /*
    Multiline String operations
     */
    val multiLineString1 =
      """
        |Hello
        |World
        |this
        |is
        |"multiline String"
      """;
    println(multiLineString1);

    val multiLineString2 =
      """
        |Hello
        |World
        |this
        |is
        |"multiline String"
      """.stripMargin.replaceAll("\n", " ");

    println(multiLineString2);

    /*
    Split string operation
     */

    val csvString = "eggs, milk, butter, coco puffs";
    csvString.split(",").map(_.trim).foreach(println);

    /*
    Substituting variable into string
     */
    val name = "Fred";
    val age = 33;
    val weight = 200.0;
    println(s"$name is of age $age and weigh $weight");
    println(f"$name is of age $age and weigh $weight%.2f");
    println(f"$name is of age $age and weigh $weight%.0f");
    println(raw"foo\nbar")

    /*
    Processing String by char.
     */
    println("hello, world".map(c => c.toUpper));
    println("hello, world".map(_.toUpper));
    println("hello, world".filter(_ != 'l').map(_.toUpper));

    for (c <- "hello, world") {
      println(c);
    }

    for (c <- "hello, world") yield (println(c));

    /*String Patterns*/
    val numPatter = "[0-9]+".r;

    var address = "123 Main Street Suite 101";

    println(numPatter.findFirstIn(address));

    address = "Main Street Suite";

    println(numPatter.findFirstIn(address).getOrElse("Num Patter not found in string"))

    /*
    Replace string patterns.
     */

    address = "123 Main Street Suite 101";

    println(address.replaceAll("[0-9]", "x"));

    val pattern = "([0-9]+) ([A-Za-z]+)".r;

    val pattern(count, fruit) = "100 Bananas";

    println(s"Count = $count Fruit = $fruit");
  }
}