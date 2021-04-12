package lectures.part2oop

object Generics extends App {

  // *****************************************************************************
  // Generic types: e.g., revisiting the linked list example, now
  // using generic type A instead of integers
  // "MyList[A]" reads: "MyList parameterized with A"
  // *****************************************************************************
  class MyList[+A] {

    // Example: A = Cat, B = Animal; then adding a list of B
    // into a list of A turns the entire list into a more generic list
    // (i.e., list of B)
    def add[B >: A](element:B): MyList[B] = ??? // B >: A means "B superclass of A"

  }

  class MyMap[Key, Value] {
    // use generic types Key, Value
  }

  //Generic types also works for trait:
  trait MyTrait[B] {
    // use generic type B
  }

  // The type used in the instance (in this case, Int), will replace the
  // generic type A
  val listOfIntegers = new MyList[Int]

  // The type used in this instance (in this case, String), will replace
  // the generic type A
  val listOfStrings = new MyList[String]

  // *****************************************************************************
  // Generic methods
  // Note: objects cannot be type parameterized
  // *****************************************************************************
  object MyList{
    def empty[A]: MyList[A] = ??? // returns nothing
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // *****************************************************************************
  // Variance problem: if Cat extends Animal, does a list of Cats extends a list of
  // Animals
  // *****************************************************************************
  class Animal
  class Cat extends Animal
  class Dog extends Animal
  class Crocodile extends Animal

  // We want to declare a class MyList[ ] with a generic type

  // The VARIANCE question:
  // If Dogs are Animals, then is a MyList[Dog] also a MyList[Animal]?
  // There are three possible answers:

  // 1. yes: then, generic type is COVARIANT and we use MyList[+T]
  //class MyList[+T]
  //val animals: MyList[Animal] = new MyList[Dog]

  // 2. no: then generic type is INVARIANT and we use MyList[T]
  //class MyList[T]
  //val animal: MyList[Animal] = new MyList[Animal]

  // 3. hell-no!: then generic type is CONTRAVARIANT
  //class Vet[-T]
  //val lassiesVet: Vet[Dog] = new Vet[Animal]


  // *****************************************************************************
  // bounded types
  // *****************************************************************************
  // class Cage only accepts type parameters A, which are subtypes of Animal
  class Cage[A <: Animal](animal:A)
  val cage = new Cage(new Dog) // allowed

  //class Car
  //val newCage = new Cage(new Car) // not allowed! Car is not an Animal

}
