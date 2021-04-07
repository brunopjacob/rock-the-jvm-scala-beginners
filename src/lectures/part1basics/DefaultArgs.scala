package lectures.part1basics

object DefaultArgs extends App {

  // **********************************************************
  // Example
  // **********************************************************

  // By specifying the argument acc: Int = 1, we are setting
  // its default value to 1. So if no value is passed in the
  // function call, the compiler assumes acc = 1.
  def tailRecursiveFactorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else tailRecursiveFactorial(n = n - 1, n * acc)
  }
  println(tailRecursiveFactorial(n = 6))

  // Good practice: always name your arguments and specify
  // which ones you are passing when calling the function
  // Note: if parameters are named, you can pass them at
  // any order you want!

}
