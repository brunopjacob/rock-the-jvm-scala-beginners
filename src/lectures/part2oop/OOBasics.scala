package lectures.part2oop

object OOBasics extends App {

  // Instantiates a class! (uses operator "new")
  val person = new Person(name = "John", age = 26)
  println(person.age)
  println(person.x)
  person.greet(name = "Daniel")
  person.greet()
}

// Creates a class!
// Notes:
// The parameters passed to the class form the primary constructor
// This constructor means that every single instance of Person must be constructed by passing in a "name" and "age"
// By default, class parameters are not attributes! (i.e., cannot access via .)
// In order to make them an attribute (aka a field), add val or var keyword before them, e.g., ( ... val age: Int)
class Person(name: String, val age: Int = 0){

  // val and var inside class definition blocks are fields! (accessible via . command)
  val x = 2

  // At every instantiation of a class, the entire body block will be evaluated, and side effects are executed first
  println("Hi!")

  // We can also define functions (methods)
  // Notice: this is equivalent to "self" in python: it refers to the name field of the class instance, not the
  // name parameter of the greet method!
  def greet(name: String): Unit = {
    println(s"${this.name} says: Hi, $name")
  }

  // Overloading: defining methods with the same name but different signatures
  // Example: another form of greet:
  def greet(): Unit = {
    println(s"Hi, I'm $name!")
  }

  // Multiple constructors (aka overloading constructors / auxiliary constructors)
  // Problem: the implementation of an auxiliary constructor MUST BE another constructor, and nothing else!
  // ** This problem can be avoided completely by providing default values for the parameters in the constructor! **
  def this(name: String) = this(name, 0) // notice how this calls the primary constructor
  def this() = this("John Doe") // this calls the auxiliary constructor above, which in turn calls the primary constructor

}