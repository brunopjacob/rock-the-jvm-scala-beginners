package lectures.part2oop

object MethodNotations extends App {

  // *****************************************************************************
  // Let's talk about some cool features of Scala that makes it resemble
  // the logic of natural language!
  // *****************************************************************************


  // *****************************************************************************
  // We are creating the class Person inside the object MethodNotations because otherwise
  // it will conflict with the other class Person created in part2oop/OOBasics.scala.
  // *****************************************************************************
  class Person(val name: String, favoriteMovie: String) {

    def likes(movie: String): Boolean = {
      movie == favoriteMovie
    }

    def hangOutWith(person: Person): String = {
      s"${this.name} is hanging out with ${person.name}"
    }

    def +(person: Person): String = {
      s"${this.name} loves ${person.name}"
    }

    // Notice: the space between unary_! and : is because otherwise the compiler will think that : is part of the name
    // of the method
    def unary_! : String = {
      s"$name, what the heck?!"
    }

    def isAlive: Boolean = {
      true
    }

    def apply(): String = {
      s"Hi, my name is $name and I like $favoriteMovie"
    }

  }

  // Let's create an instance of Person:
  val mary = new Person(name = "Mary", favoriteMovie = "Inception")

  // Using the method likes, we can ask questions like:
  println(mary.likes("Inception")) // Look how cool this is!

  // Wait, it gets better: the following expression is equivalent to the one above:
  println(mary likes "Inception") // Crazy, isn't it? This is **infix notation**, aka operator notation

  // NOTE: Infix notation only works with methods with a single parameter.

  // INFIX NOTATION IS AN EXAMPLE OF WHAT IS CALLED "SYNTACTIC SUGAR"

  // *****************************************************************************
  // "Operators" in Scala: infix notation
  // *****************************************************************************
  val tom = new Person(name = "Tom", favoriteMovie = "Fight Club")
  println(mary hangOutWith tom)
  // hangOutWith acts as an operator with mary and tom, which yields a string!

  // Scala is very permissive with operator naming: we could, for instance, rename
  // hangOutWith with a + and use it! Example: + yielding "this loves other"
  println(mary + tom) // this is equivalent to calling mary.+(tom)

  // This is also the case for the "usual" sum (+) operator between numbers:
  println(f"${1 + 2} is equivalent to ${1.+(2)}")

  // ALL OPERATORS ARE METHODS IN SCALA!


  // *****************************************************************************
  // Prefix notation: (more syntactic sugar)
  // *****************************************************************************
  val x = -1
  // This is equivalent to writing the following:
  val y = 1.unary_-

  // unary_ prefix only works with, -, +, ~, !
  // Example:
  println(!mary) // Equivalent to mary.unary_!

  // *****************************************************************************
  // Postfix notation: (more syntactic sugar)
  // *****************************************************************************
  // Methods that do not receive any parameters can be used in the postfix notation
  // This, however, is not very used in practice, as it's very close to mary.isAlive
  // which is basically the same but using a space instead of a dot.
  // Postfix notation can cause ambiguities when reading code (not to the compiler, but
  // to humans.
  println(mary.isAlive)
  // println(mary isAlive) // This is not recommended

  // *****************************************************************************
  // apply: special method name that enables to use the instance to behave like a
  // method, enabling something like mary()
  // This really breaks the barrier between OOP and FP!!
  // *****************************************************************************
  println(mary.apply())
  println(mary()) // equivalent to mary.apply()!

}
