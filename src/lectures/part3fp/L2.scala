package lectures.part3fp

object L2 extends App {

  //Instead of writing all of the following:
  val doublerV1: (Int => Int) = new Function1[Int, Int] {
    override def apply(a: Int): Int = a * 2
  }

  // We can reduce it to the equivalent anonymous function (lambda)
  val doublerV2: (Int => Int) = (a: Int) => a * 2

  // or even cleaner (compiler assumes types are correct)
  val doublerV3: (Int => Int) = a => a * 2

  println(doublerV3(5))

  // Multiple parameters in a lambda:
  val adder: ((Int, Int) => Int) = (a, b) => a + b

  println(adder(3, 4))

  // We can also have no parameter lambdas:
  val justDoIt: (() => String) = () => "Blah"

  // Notice! Printing justDoIt returns the lambda, vs printing justDoIt() returns the lambda result!
  println(justDoIt)
  println(justDoIt())

  // Curly braces with lambdas:
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // ======================
  // MOAR syntactic sugar:
  // ======================

  val niceIncrementer: (Int => Int) = _ + 1 // equivalent to x => x + 1

  val niceAdder: ((Int, Int) => Int) = _ + _ // equivalent to (x,y) => x + y

  // Exercise:

  val superAdder: (Int => (Int => Int)) = a => (b => a + b)
  println(superAdder(3)(4))
}
