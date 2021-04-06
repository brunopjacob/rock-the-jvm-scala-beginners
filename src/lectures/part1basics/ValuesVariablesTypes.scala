package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // **********************************************************
  // VALS (immutable!)
  // **********************************************************
  // p.s.: compiler can infer types

  // Strings
  val aString: String = "hello"
  val anotherString = "goodbye"

  // Booleans
  val aBoolean: Boolean = true // or false

  // Characters
  val aChar: Char = 'a' // single characters between single quotes

  // Ints, shorts, longs, floats, etc
  val aShort: Short = 4613
  val anInt: Int = x
  val aLong: Long = 444444444444L
  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  // **********************************************************
  // Variables (mutable!)
  // **********************************************************
  var aVariable: Int = 4
  aVariable = 5 // side effects

}
