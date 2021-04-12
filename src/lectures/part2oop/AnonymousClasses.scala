package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // This is an anonymous class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("ahahahahaha")
  }
  println(funnyAnimal.getClass)

  // This is not an anonymous class
  class MyAnimal extends Animal{
    def eat: Unit = println("HAHAHAHAHA")
  }
  val funnyAnimal2: MyAnimal = new MyAnimal
  println(funnyAnimal2.getClass)
}
