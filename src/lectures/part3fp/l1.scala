package lectures.part3fp

object l1 extends App {

  // A function that takes 2 strings and concatenate them
  def stringConcatenator: (String, String) => String =
    new ((String, String) => String) {
      override def apply(a: String, b: String): String = a + b
    }

  val stringConcatenatorAsVal: (String, String) => String =
    new ((String, String) => String) {
      override def apply(a: String, b: String): String = a + b
    }

  println(stringConcatenator("Cheems", "Burger"))
  println(stringConcatenatorAsVal("Cheems", "Burger"))

  // A function that takes an int and returns another function which takes an int and returns an int
  // This is called a "curried" function
  def superAdder: (Int => (Int => Int)) = new (Int => (Int => Int)) {
    override def apply(a: Int): (Int=>Int) = new (Int=>Int) {
      override def apply(b: Int): Int = a + b
    }
  }

  println(superAdder(3)(5))

  // The simplified version of the curried function above is almost illegible imho... but here it is:
  def superAdderHardToRead: (Int => (Int => Int)) = (a: Int) => (b: Int) => a + b

  println(superAdderHardToRead(3)(5))

}
