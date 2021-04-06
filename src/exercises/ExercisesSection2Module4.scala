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
  print(funGreeting(name="Bob", age = 25))

  /*
  2. Write a function that computes the factorial of a number n
  (use recursion)
   */
  def funFactorial(n: Int): Int = {
    if (n<=0) 1 else n * funFactorial(n = n-1)
  }
  println(funFactorial(n=5))

  /*
  3. Write a function that computes the n-th Fibonacci number, where
  f(1) = 1, f(2) = 1, ... f(n) = f(n-1) + f(n-2)
  */
  def funFibonacci(n: Int): Int = {
    if (n<= 2) 1 else funFibonacci(n = n-1) + funFibonacci(n = n-2)
  }
  println(funFibonacci(n=8))

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
