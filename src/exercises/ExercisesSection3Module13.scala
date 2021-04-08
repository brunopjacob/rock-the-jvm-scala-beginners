package exercises

object ExercisesSection3Module13 extends App {


  class Person(val name: String, val age: Int = 0, favoriteMovie: String) {

    def +(nickname: String): Person = {
      new Person(name = s"$name ($nickname)", age, favoriteMovie)
    }

    def +(person: Person): String = {
      s"${name} is hanging out with ${person.name}"
    }

    def unary_+ : Person = {
      new Person(name, age+1, favoriteMovie)
    }

    def learns(subject: String): String = {
      s"$name learns $subject"
    }

    def learnsScala: String = {
      //learns(subject = "Scala")
      // could also write:
      this learns "Scala"
    }

    def apply(): String = {
      s"$name watched $favoriteMovie"
    }

    def apply(n: Int): String = {
      s"${this()} $n times"
    }


  }


  /*
  1. Overload the + operator:
  example: mary + "the rockstar" => returns a new person, "Mary (the rockstar)"
  */
  val mary = new Person(name = "Mary", age = 28, favoriteMovie = "Inception")
  val newPerson: Person = mary + "the rockstar"
  println(newPerson.name)


  /*
  2. Add an age to the Person class (default value 0)
  Add an unary_ + operator => returns a new person with age +1
  example: +mary => mary with an age incrementer
  */
  val olderMary = +mary
  println(s"Hi, I'm the older ${olderMary.name} and I'm ${olderMary.age}")
  println((+mary).age) // returns Mary's age + 1

  /*
  3. Add a "learns" method in the Person class => Mary learns Scala
  Add a learnsScala method, calls the learns method with "Scala"
  Use it in postfix notation
   */
  val bob = new Person(name = "Bob", age = 32, favoriteMovie = "Avengers")
  println(bob.learns(subject="Python"))
  println(bob.learnsScala)

  /*
  4. Overload the apply method:
  mary.apply(2) => "Mary watched Inception 2 times"
  */
  println(mary.apply(2))

}


