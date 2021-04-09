package lectures.part2oop

object Objects extends App {

  // ***********************************************************************
  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY!!!!
  // i.e., SCALA DOES NOT HAVE "STATIC"
  // However: objects can have a static-like functionality
  // Note: OBJECTS CAN BE DEFINED IN A SIMILAR WAY THAT CLASSES CAN,
  // BUT THEY DO NOT RECEIVE PARAMETERS (NO CONSTRUCTOR)
  // ***********************************************************************
  object Person {
    //"static"/"class"-level functionalities

    val N_EYES = 2
    def canFly(): Boolean = {
      false
    }

    // Note: The object Person can crete new instances of the class Person!
    // This is called a FACTORY METHOD; it's purpose is to build instances
    // given some parameters
    def from(mother: Person, father: Person): Person = {new Person(name = "Bob")}

    // The factory method above can also be written using the apply() method, to
    // simplify notation when calling it!
    def apply(mother: Person, father: Person): Person = {new Person(name = "Bob")}

  }

  class Person(val name: String) {
  // instance-level functionalities
  }

  // We can then access N_EYES as:
  println(Person.N_EYES)

  // This is a bit different from the Java approach, as objects can have
  // vals, vars and object definitions
  println(Person.canFly())

  // ***********************************************************************
  // Scala object is a SINGLETON INSTANCE by definition
  // Meaning: when we define an object, we define its type + its only instance
  // Therefore, the object is its own type (in the example above, type Person),
  // and it is its only instance
  // ***********************************************************************
  //Example:
  val mary = Person // This is an INSTANCE! An instance of the Person type
  val john = Person // Person is a single instance! so mary and john are actually pointing to the same instance
  println(mary == john)


  // ***********************************************************************
  // We often write classes and objects with the same name
  // with the purpose of separating instance-level functionalities
  // from "static/class" - level functionalities
  // This pattern of writing classes and objects with the same name in the
  // same scope is called COMPANIONS.
  // E.g.: class Person and object Person are companions, as they reside in
  // the same scope and have the same name
  // Note: object/class companions can access each other's private members
  // ***********************************************************************
  val mary2 = new Person(name = "Mary")
  val john2 = new Person(name = "John")
  println(mary2 == john2)

  // ***********************************************************************
  // Factory methods!
  // Note: can also be transformed into an apply() method, to make notation
  // easier!
  // ***********************************************************************
  val bob = Person.from(mother = mary2, father = john2)
  println(bob.name)

  // We make the Person singleton instance object to behave like a function by using the apply method!
  val bob2 = Person(mother = mary2, father = john2)
  println(bob2.name)


  // ***********************************************************************
  // Scala APPLICATIONS: scala object with def main method:
  //
  // def main(args: Array[String]): Unit
  //
  // This has to have this specific name and definition, because Scala
  // applications are turned into java virtual machine (JVM) applications,
  // whose entry point has to be :
  //
  // public static void main(String args[])
  //
  // So instead of using "extends App" in the object definition, we can also
  // define the main class as specified above.
  // ***********************************************************************


}
