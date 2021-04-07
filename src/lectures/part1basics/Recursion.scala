package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App{

  // **********************************************************
  // Tail recursion
  // **********************************************************

  // Use annotation @tailrec so the compiler indicate if the function is tail recursive or not
  // Any function can be turned into a tail recursive function
  // When you need loops, use tail recursion!

  // Examples:
  // 1. Concatenate a string n times, tail recursive form
  @tailrec
  def concatenateTail(n: Int, s: String, accumulator: String = ""): String = {
      if (n<=0) return accumulator
      else concatenateTail(n = n-1, s = s, accumulator = accumulator+s)
    }
  println(concatenateTail(n = 10, s = "Hi!"))


  // 2. IsPrime function, tail recursive form
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTail(t: Int, isStillPrime : Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTail(t-1, n % t != 0 && isStillPrime)
    }
    isPrimeTail(t = n/2, isStillPrime= true)
  }
  println(isPrime(n = 13))


  // 3. Fibonacci function, tail recursive form
  // Rule of thumb: number of accumulators = number of recursive calls in the naive recursive form of the function
  // in this case: naive recursive Fibonacci function calls fib(n-1) + fib(n-2), so we need 2 accumulators (a and b).
  @tailrec
  def fibTail(n: Int, a: Int = 0, b: Int = 1): Int = {
    if (n == 1) return b
    else if (n <= 0) return a
    else fibTail(n = n - 1, a = b, b = a + b)
  }
  println(fibTail(n = 8))

}
