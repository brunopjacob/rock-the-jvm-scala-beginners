package exercises

object ExercisesSection3Module11 extends App {

  // Exercise 1: testing Writer and Novel classes
  val writer1 = new Writer(firstName = "Average", lastName = "Joe", yearOfBirth = 1980)
  println(s"Author's full name: ${writer1.fullName()}")

  val novel1 = new Novel(name="Blah blah blah 1", yearOfRelease = 2019, author = writer1)
  println(s"Novel was written by ${writer1.fullName()}: ${novel1.isWrittenBy(author = writer1)}")
  println(s"The author age at the time of publication was ${novel1.authorAge()}")

  val novel1_v2 = novel1.copy(yearOfRelease = 2021)
  println(s"Novel was written by ${writer1.fullName()}: ${novel1_v2.isWrittenBy(author = writer1)}")
  println(s"The author age at the time of publication was ${novel1_v2.authorAge()}")


  // Exercise 2: testing the Counter class
  val newCounter = new Counter(value = 4)
  println(s"Base case: current value = ${newCounter.value}")
  newCounter.increment().increment().increment().print() // prints "Incrementing" and increments 3
  newCounter.increment(n=5).print()


}

/* Exercise 1: write two classes, Novel and Writer:

Writer: first name, surname, year of birth
  - methods:
    fullName (returns the concatenation of first name and last name)

Novel: name, year of release, author (instance of type writer)
  - methods:
    authorAge (returns the age of the author at the year of release)
    isWrittenBy(author)
    copy (receives a new year of release)  = new instance of Novel

*/
class Writer(firstName: String, lastName: String, val yearOfBirth: Int) {

  // I like to put parenthesis in all the empty paren methods, to differentiate them
  // from attributes. That's just my style of coding, but not needed!
  def fullName(): String = {
    s"$firstName $lastName"
  }
}

class Novel(name: String, yearOfRelease: Int, author: Writer) {

  def authorAge(): Int = {
      yearOfRelease - author.yearOfBirth
  }

  def isWrittenBy(author: Writer): Boolean = {
    author == this.author
  }

  def copy(yearOfRelease: Int): Novel = {
    new Novel(this.name, yearOfRelease, this.author)
  }

}

  /*
  Exercise 2: Counter class (receives an int value)
  - methods:
    current count
    increment /decrement => new Counter
    overload increment/decrement to receive an amount
   */
class Counter(val value: Int) {

    /*
     Note: defining a method current() and returning value has the same effect of
     defining it as an attribute instead of a parameter (i.e., adding val before its declaration in the
     constructor.
    def current():Int = {
      value
    }
     */

    /*
    The fact that we are defining new instances of Counter
    instead of just modifying the existent Counter.value is
    an example of IMMUTABILITY.
    This is important as it guarantees that instances are fixed
    and will not be modified.

    def increment(x:Int = 1):Counter = {
      new Counter(value = value+x)
    }

    def decrement(x:Int = 1):Counter = {
      new Counter(value = value-x)
    }
    */

    /* In case we want a more functional programming version
    of increment and decrement, we can use method overloading:
     */
    def increment(): Counter = {
      println("Incrementing")
      new Counter(value = value + 1)
    }

    def decrement(): Counter = {
      println("Decrementing")
      new Counter(value = value - 1)
    }

    def increment(n:Int): Counter = {
      if (n <= 0) this
      else increment().increment(n-1)
    }

    def decrement(n:Int): Counter = {
      if (n <= 0) this
      else decrement().decrement(n-1)
    }

    def print(): Unit = {
      println(s"Value = $value")
    }

  }

