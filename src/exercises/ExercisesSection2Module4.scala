package exercises

import scala.annotation.tailrec

object ExercisesSection2Module4 extends App {

  /*
  1. Write a greeting function that takes (name, age) and returns a string
  "Hi, my name is $name and I am $age years old"
  */
  def funGreeting(name: String, age: Int): String = {
    "Hi, my name is " + name + " and I am " + age + " years old."
  }
  println(funGreeting(name="Bob", age = 25))

  /*
  2. Write a function that computes the factorial of a number n
  (use recursion)
   */
  // Implementation without tail recursion (memory intensive)
  def funFactorial(n: Int): Int = {
    if (n<=0) 1
    else n * funFactorial(n = n-1)
  }
  println(funFactorial(n=5))

  // Implementation with tail recursion (low memory footprint)
  def funFactorialTail(n: BigInt): BigInt = {
    def go(x: BigInt, accumulator: BigInt): BigInt = {
      if (x == 1) return accumulator
      else go(x - 1, x * accumulator)
    }
    go(x = n, accumulator = 1)
  }
  println(funFactorialTail(n=60))

  /*
  3. Write a function that computes the n-th Fibonacci number, where
  f(0) = 0, f(1) = 1, f(2) = 1, ... f(n) = f(n-1) + f(n-2)
  */
  // Fibonacci recursive (inefficient)
  def funFibonacci(n: Int): Int = {
    if (n<= 2) 1
    else funFibonacci(n = n-1) + funFibonacci(n = n-2)
  }
  println(funFibonacci(n=8))

  // Fibonacci tail recursive (efficient)
  def funFibonacciTail(n: BigInt): BigInt = {
    def go(x: BigInt, a: BigInt, b: BigInt): BigInt = {
      if (x == 0) a
      else if (x == 1) b
      else go(x = x-1, a = b, b = a + b)
    }
    go(x=n, a = 0, b = 1)
  }
  println(funFibonacciTail(n=50))


  /*
  4. Write a function that tests if a number is prime
  */
  def funTestPrime(n: Int): Boolean = {

    // Auxiliary function: does n has any divisors up to t?
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t = t - 1)
    }
    isPrimeUntil(t = n / 2)
  }
  println(funTestPrime(n=7))
  println(funTestPrime(n=31))
  println(funTestPrime(n=7*31))


}
