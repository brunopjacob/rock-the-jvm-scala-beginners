package lectures.part1basics

object Functions extends App {

  // Defining functions in scala!

  // ****************************************
  // Example 1: this function takes two arguments (a and b)
  // and returns a string (last line in the block)
  // ****************************************
  def aFunction(a: String, b: Int): String = {
    a + " " + b // + here is string concatenation
  }
  println( aFunction("hello",3))


  // ****************************************
  // Example 2: functions can also take no argument
  // ****************************************
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())

  // Notice: parameterless functions can also be called without ():
  println(aParameterlessFunction)


  // ****************************************
  // Example 3: a recursive example
  // Instead of using loops, in a function language you will use recursion
  // WHEN YOU NEED LOOPS, USE RECURSION!!
  // ****************************************
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString else aString + aRepeatedFunction(aString = aString, n = n-1)
  }
  println(aRepeatedFunction(aString = "blah", n = 3))


  // ****************************************
  // Example 4: functions that only execute side effects
  // i.e., (return unit) can also be created
  // ****************************************
  def aFunctionWithSideEffect(aString: String): Unit = {
    println(aString) // this returns unit
  }

  // ****************************************
  // Example 5: blocks of code can also have
  // functions defined inside of them
  // ****************************************
  def  aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int ): Int = {
      a + b
    }
    aSmallerFunction(n,n-1)
  }


  // ****************************************
  // Exercises:
  // ****************************************
  /*
  1. Write a greeting function that takes (name, age) and prints
  "Hi, my name is $name and I am $age years old"

  2. Write a function that computes the factorial of a number n
  (use recursion)

  3. Write a function that computes the n-th Fibonacci number, where
  f(1) = 1, f(2) = 1, ... f(n) = f(n-1) + f(n-2)

   4. Write a function that tests if a number is prime
   */


}

