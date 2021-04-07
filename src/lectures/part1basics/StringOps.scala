package lectures.part1basics

object StringOps extends App {

  // Introduction to Strings!

  // **********************************************************
  // Strings have a bunch of nice methods:
  // (all of the following are actually from Java)
  // **********************************************************
  val str: String = "Hello, I am learning Scala"

  // "charAt" returns char of object str at specified position
  println(str.charAt(2)) // prints "l" (Scala is 0-indexed)

  // "substring" returns string in between beginIndex, endIndex
  println(str.substring(7, 11)) // prints "I am"

  // "split" method returns an array with separated strings (sep. " ")
  println(str.split(" ").toList)

  // "startsWith" returns Boolean result of a test
  println(str.startsWith("Hello"))

  // "replace" replaces a target match by a replacement within a string
  println(str.replace(" ","_") ) //e.g., replaces " " by _

  // "toLowerCase" turns all chars into lowercase
  println(str.toLowerCase())

  // "toUpperCase" turns all chars into uppercase
  println(str.toUpperCase())

  // "length" gives the length of a string
  // NOTE: methods/functions without parameters can be called without
  // parenthesis
  println(str.length())

  // **********************************************************
  // Scala-specific methods
  // **********************************************************

  // "toInt" converts a string in Scala to Int
  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println(aNumber)

  // Prepend (+:) and append (:+):
  println('a' +: aNumberString :+ 'z')

  // "reverse" reverses a string
  println(aNumberString.reverse)

  // "take" returns n first characters of a string
  println(str.take(3)) // returns "Hel"

  // **********************************************************
  // String interpolators
  // **********************************************************

  // S-interpolators: can evaluate complex operators (using ${} expressions)
  val name: String = "David"
  val age: Int = 12
  val greeding = s"Hello, my name is $name and I am $age years old"
  println(greeding)
  val anotherGreeding = s"Hello, my name is $name and I will be turning ${age + 1} years old"
  println(anotherGreeding)

  // F-interpolators: they can also evaluate complex operators,
  // and in addition they can receive printf-like formats!
  // e.g. %2.2f = 2 characters total (minimum), 2 characters precision, float
  // %s = string
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // Raw-interpolator: works the same as the s-interpolator,
  // but has the property that it can print characters literally
  // Example: if you want to print \n **literally**
  println(raw"This is a \n newline")
  //However: if string is interpolated, it evaluates \n:
  val escaped = "This is a \n newline"
  println(raw"$escaped")

}
