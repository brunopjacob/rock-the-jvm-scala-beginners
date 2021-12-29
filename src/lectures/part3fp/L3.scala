package lectures.part3fp

object L3 extends App {

  // Higher-order functions (HOFs): take as input (or returns as output) functions
  // Examples: map, flatMap, filter

  // Example: function that applies a function f n times over a value x
  // i.e, nTimes(f, n, x)
  // Example: nTimes(f, 3, x) = f(f(f(x))) (or, using composition notation, (f o f o f)(x) )
  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  val plusOne: (Int => Int) = (x: Int) => x + 1

  println(nTimes(plusOne, 5, 1))

  // Alternative, more clean way of constructing the same HOF:
  def nTimesBetter(f: Int => Int, n: Int): (Int => Int) = {
    if (n <= 0)
      (x: Int) => x
    else
      (x: Int) => nTimesBetter(f, n - 1)(f(x))
  }

  println(nTimesBetter(plusOne, 5)(1))


  // Curried functions
  val superAdder: (Int => (Int => Int)) = (x: Int) => ((y: Int) => x + y)

  val add3: (Int => Int) = superAdder(3)
  println(add3(6)) // adds 3 to 6



  // Functions with multiple parameter lists: these act like curried functions
  def curriedFormatter(c: String)(x: Double): String = c.format(x)

  val standardFormat: (Double=>String) = curriedFormatter("%4.2f")
  val preciseFormat: (Double=>String) = curriedFormatter("%10.8f")

  println(standardFormat(Math.PI))
  println(preciseFormat(Math.PI))



}
