package playground

object Tests extends App {

  abstract class AbstractList[+T]

  class MyList[T](val head: T, val tail: AbstractList[T]) extends AbstractList[T]

  object EmptyList extends AbstractList[Nothing] // (singleton) instance of itself!

  val list =  new MyList( head = 3, tail = EmptyList)

  println(list.head)

}
