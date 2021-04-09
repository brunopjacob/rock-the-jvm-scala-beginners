package lectures.part2oop

object AbstractDataTypes extends App {

  // *****************************************************************************
  // abstract: classes, vals, methods, etc can be abstract.
  // In the example below, creatureType and eat are an abstract val and an abstract
  // method, respectively, since we do not supply values for them.
  // Usage: you declare things abstract when you want the subclasses to define
  // values for the vals and methods of a given superclass!
  // Note 1: abstract classes cannot be instantiated. Abstract classes are meant to
  // be extended later.
  // Note 2: you can either use the keyword override in the subclass' values and
  // methods or not. It's optional (the compiler infer automatically)
  // *****************************************************************************
  abstract class Animal {
    val creatureType: String // Notice how this is abstract
    def eat: Unit // Notice how this is abstract
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine" // Note: override keyword is optional
    override def eat: Unit = println("crunch crunch") // Note: override keyword is optional
  }

  // *****************************************************************************
  // Traits: ultimate abstract data types in Scala!
  // Creation: use the keyword "trait"
  // Note 1: unlike abstract classes, they can be inherited along classes using the
  // keyword "with"
  // Note 2: we can add more than 1 trait, by repeating the keyword with:
  // e.g., class Crocodile extends Animal with Carnivore with AnotherTrait with ...
  // Note 3: Abstract classes can have abstract AND non-abstract members
  // Note 4: Traits can also have abstract AND non-abstract members
  // *****************************************************************************
  trait Carnivore {
    def eat(animal: Animal): Unit // Notice how this is abstract
  }

  // Crocodile inherits members of the abstract class Animal AND trait Carnivore
  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"
    def eat: Unit = println("nomnomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile

  // This will call the method eat of the class Crocodile
  crocodile.eat

  // This will call the method eat(animal: Animal) of the class Crocodile
  crocodile.eat(dog)

  // *****************************************************************************
  // Traits vs abstract classes:
  // Difference #1: traits do not have constructor parameters
  // Difference #2: you can only extend one class (keyword "extends"),
  // but you can add multiple traits (keyword "with")
  // Difference #3: we choose a trait vs an abstract class if it describes a type of
  // behavior. Thus: trait = behavior, abstract class = "thing"
  // Example: Animals (class) describe a thing, and Carnivore (trait) describe what they do.
  // *****************************************************************************



}
