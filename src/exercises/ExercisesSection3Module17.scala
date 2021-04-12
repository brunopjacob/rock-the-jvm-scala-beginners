package exercises

object ExercisesSection3Module17 extends App {

  abstract class MyList {

    /*
  ** MyList is an abstract class **
  It helps in the implementation of a singly linked list.
  Methods:
    -head => value of the first element of the list
    -tail => remainder of the list
    -isEmpty => is this list empty? Returns Boolean
    -add(Integer) => new list with this new element added
    -toString => a string representation of the list
   */
    def head: Int

    def tail: MyList

    def isEmpty: Boolean

    def add(element: Int): MyList

    def printElements: String

    // polymorphic call
    override def toString: String = "[" + printElements + "]" // needs an override here because toString is a Scala method

  }

  object Empty extends MyList {
    def head: Int = throw new NoSuchElementException

    def tail: MyList = throw new NoSuchElementException

    def isEmpty: Boolean = true

    def add(element: Int): MyList = new Cons(element, Empty)

    def printElements: String = ""
  }

  class Cons(h: Int, t: MyList) extends MyList {
    def head: Int = h

    def tail: MyList = t

    def isEmpty: Boolean = false

    def add(element: Int): MyList = new Cons(element, this)

    def printElements: String =  {
      if (t.isEmpty) "" + h
      else h + " " + t.printElements
    }
  }

  // Testing creating a new list
  val list = new Cons(1, Empty)
  println(list.head)

  // Testing list with multiple nodes
  val list2 = new Cons(1, new Cons(3, new Cons (5, Empty)))
  println(list2.tail.head)

  // Testing add method
  println(list.add(4).head)

  // polymorphic call example here: toString in MyList will call the appropriate printElements
  // depending on the list
  println(list2.toString)


}