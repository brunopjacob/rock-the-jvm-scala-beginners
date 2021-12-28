package lectures.part2oop

object CaseClasses extends App {

  // *****************************************************************************
  // Allows declaring a class and a companion object along with some basic
  // canonical methods, such as equals, hashCode, toString...
  // Notes:
  //   1. case classes automatically promote all class parameters to fields!
  //   2. sensible toString!
  //   3. equals and hashCode implemented out of the box
  //   4. case classes have handy copy methods!
  //   5. case classes have companion objects
  //   6. case classes are serializable (useful with Akka framework)
  //   7. case classes have extractor patterns: can be used in pattern matching!
  // *****************************************************************************
  case class Person(name: String, age: Int)

  // 1.
  val jim = new Person("Jim", 24)
  println(jim.name)

  // 2.
  println(jim.toString) // also equivalent to println(jim)

  // 3.
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4.
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5.
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 8.


  // *****************************************************************************
  // Notice: there are also case OBJECTS!
  // They have the same properties of case classes, except the companion objects
  // (obviously)
  // *****************************************************************************
  case object UnitedKingdon {
    def name: String = "The UK of GB and NI"
  }


}
