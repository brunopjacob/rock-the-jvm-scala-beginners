package lectures.part1basics

object CallByNameVsCallByValue extends App {

  // **********************************************************
  // This program illustrates the difference between
  // using arguments called by value or name
  // **********************************************************

  // Example: called by value
  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // Example: called by name (uses "=>")
  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(x = System.nanoTime())
  calledByName(x = System.nanoTime())

  /*
  Explanation: System.nanoTime() is evaluated BEFORE it is passed
  to the calledByValue function (so the value remains unchanged for
  both print calls). Conversely, System.nanoTime is passed literally
  (i.e., by name) to the calledByName function, and it is lazy
  evaluated (only evaluated once used inside the coding block).
  That causes System.nanoTime to yield *different values* for each
  print call.
  */

  // **********************************************************
  // Example on how lazy evaluation (called by name)
  // can make your code more robust to errors
  // **********************************************************

  // Simple function that keeps recursively going forever
  def infinity(): Int = {1 + infinity()}

  // Example of a function where one of the parameters
  // is called by name and the other is called by value;
  // notice that if we call infinity() by name and never use
  // it, the function still runs!
  def testCalls(x: Int, y: => Int): Int ={
    return x
  }
  println(testCalls(x = 1, y = infinity()))

}
