package lectures.part3fp

object L3Exercises extends App {

  /*
  toCurry(f: (Int, Int) => Int) => (Int => (Int => Int))
  fromCurry(f: (Int => Int => Int)) => (Int, Int) => Int
   */

  def toCurry(f: (Int, Int) => Int): (Int => Int => Int) = x => y => f(x,y)
  def fromCurry(f: Int => (Int => Int)): ((Int, Int) => Int) = (x,y) => f(x)(y)


  /*
  compose(f,g) => x => f(g(x))
  andThen(f,g) => x => g(f(x))
   */

  def compose[A,B,C](f: A=>B, g: C=>A): C => B =
    x => f(g(x))

  def andThen[A,B,C](f: A=>B, g: B=>C): A => C =
    x => g(f(x))


  // Testing the functions above
  def superAdder2: (Int => (Int=> Int)) = toCurry(_ + _)
  def add4: Int=>Int = superAdder2(4)
  println(add4(17))

  def simpleAdder: ((Int, Int) => Int) = fromCurry(superAdder2)
  println(simpleAdder(3,4))


  val add2 = (x: Int) => x + 2
  val times3 =(x: Int) => x * 3

  val add2_o_times3: Int => Int = compose(add2,times3)
  val times3_o_add2: Int => Int = andThen(add2,times3)

  println(add2_o_times3(2)) // should print 8
  println(times3_o_add2(2)) // should print 12


}
