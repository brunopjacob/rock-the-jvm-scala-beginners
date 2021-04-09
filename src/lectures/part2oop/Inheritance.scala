package lectures.part2oop

object Inheritance extends App {

  // *****************************************************************************
  // Scala has single class inheritance
  // *****************************************************************************
  // Single class inheritance: you can only extends one class at a time
  // Note 1: if we make method eat private, we can't call it from instances of Cat
  // Note 2: if we make the method eat protected, it is only usable within the class and subclasses, but not
  // directly in instances of Cat! e.g., we still can't call cat.eat, but we can define the crunch method inside
  // of Cat that USES the method eat.
  // Note 3: by default, methods/vals/vars/objects are public (subclasses can access these within it)


  class Animal {
    val creatureType = "wild"

    //private def eat: Unit = println("nomnomnom")
    //protected def eat: Unit = println("nomnomnom")
    def eat: Unit = println("nomnomnom")
  }

  // Class Cat inherits all the non-private fields and methods of class Animal
  // We say that Cat is a subclass of Animal
  // and we say that Animal is a superclass of Cat
  class Cat extends Animal {
    def crunch:Unit = {
      super.eat // super here is understood that it is the one from the superclass... using super.clear only to be clear
      println("crunch crunch")
    }
  }

  // We can call the method "eat" from a new instance of Cat
  val cat = new Cat
  //cat.eat
  cat.crunch

  // *****************************************************************************
  // Constructors: in order to extend a class with parameters, make sure you pass
  // the parameters of the superclass as well: e.g., ... extends Person(name, age)
  // This is important as the compiler needs to know the constructor of the
  // superclass beforehand.
  // Note 1: It is also possible to extend with an auxiliary constructor: e.g.,
  // ... extends Person(name)
  // *****************************************************************************
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // *****************************************************************************
  // Overriding: use it when you want the local def of a method to take precedence
  // over the definition of the method in the superclass.
  // Note 1: we can also override vals, vars, etc
  // Note 2: we can also override vals directly in the constructor of the class,
  // e.g., class Dog(override val creatureType) extends Animal would override
  // this field.
  // Note 3: all derived classes of the class that had a method override will call
  // inherit the override method.
  // *****************************************************************************
  class Dog(override val creatureType: String = "domestic") extends Animal {

    //override val creatureType: String = "domestic"

    override def eat: Unit = println("crunch, crunch")
  }

  val dog = new Dog
  println(dog.creatureType)
  dog.eat

  // *****************************************************************************
  // Type substitution: in a broad sense, a type of ** polymorphism **
  // *****************************************************************************
  val unknownAnimal: Animal = new Dog(creatureType = "K9")
  unknownAnimal.eat

  // Note:
  // overRIDING: supplying a different implementation in derived classes
  // vs
  // overLOADING: supplying multiple methods with different signatures but with the same name in the same class

  // *****************************************************************************
  // super: used when you want to reference a method or a filed from a parent
  // class. E.g., use super.eat to call a method from the superclass in any of the
  // subclasses
  // *****************************************************************************


  // *****************************************************************************
  // Preventing overrides:
  // Way #1: use "final": e.g., use "final def eat" in the Animal class
  // Way #2: use "final" on the class itself: e.g., use "final class Animal":
  // prevents the entire class from being extended
  // Way #3: use "sealed" on class: allows class extension on THIS FILE, but prevents
  // extension in other files.
  // *****************************************************************************


}
