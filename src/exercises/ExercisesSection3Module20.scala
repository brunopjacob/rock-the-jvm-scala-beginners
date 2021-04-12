package exercises

object ExercisesSection3Module20 extends App {

  /* Exercises
  1. Generic trait MyPredicate[-T] with a little method test(T) => Boolean
  2. Generic trait MyTransformer[-A,B] with a method transform(A) => B
  3. MyList:
     - map(transformer) => MyList
     - filter(predicate) => MyList
     - flatMap(transformer from A to MyList[B]) => MyList[B]

     class EvenPredicate extends MyPredicate[Int]
     class StringToIntTransformer extends MyTransformer[String, Int]

     example (pseudocode)
     [1,2,3].map(n*2) = [2,4,6]
     [1,2,3,4].filter(n % 2) = [2,4]
     [1,2,3].flatMap(n=> [n,n+1]) => [1,2,2,3,3,4]

   */

  abstract class MyList[+A] {

    def head: A
    def tail: MyList[A]
    def isEmpty: Boolean
    def add[B >: A] (element: B): MyList[B]
    def printElements: String
    override def toString: String = "[" + printElements + "]"

    def map[B](transformer: MyTransformer[A,B]): MyList[B]
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]
    def filter(predicate: MyPredicate[A]): MyList[A]
    def ++[B >: A](list: MyList[B]): MyList[B] // concatenation
  }

  object Empty extends MyList[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyList[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
    def printElements:String = ""

    def map[B](transformer: MyTransformer[Nothing,B]): MyList[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
    def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty

    def ++[B >: Nothing](list: MyList[B]): MyList[B] = list

  }

  class Cons[+A](h: A, t: MyList[A] ) extends MyList[A] {
    def head: A = h
    def tail: MyList[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyList[B] = new Cons(element, this)
    def printElements: String = {
      if (t.isEmpty) "" + h
      else h + " " + t.printElements
    }

    // Explanation, step-by-step:
    /* E.g. [1,2,3] is the original list
    [1,2,3].map(n * 2) pseudocode;
         = new Cons(2, [2,3].map(n * 2))
         = new Cons(2, new Cons(4, [3].map(n * 2)))
         = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
         = new Cons(2, new Cons(4, new Cons(6, Empty))))
     */
    def map[B](transformer: MyTransformer[A,B]): MyList[B] = {
      new Cons(transformer.transform(h), t.map(transformer))
    }


    // Explanation, step-by-step:
    /* E.g. [1,2,3] is the original list
    [1,2,3].filter(n % 2 == 0) pseudocode;
         = [2,3].filter(n % 2 == 0) =
         = new Cons(2, [3].filter(n % 2 == 0)
         = new Cons(2, Empty.filter(n % 2 == 0))
         = new Cons(2, Empty)
     */
    def filter(predicate: MyPredicate[A]): MyList[A] = {
      if ( predicate.test(h) ) new Cons(h, t.filter(predicate))
      else t.filter(predicate)
    }


    // Explanation, step-by-step:
    /* E.g. [1,2] ++ [3,4,5]
         = new Cons(1, [2] ++ [3,4,5]
         = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
         = new Cons(1, new Cons(2, [3,4,5])
         = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
     */
    def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)
    def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = transformer.transform(h) ++ t.flatMap(transformer)

  }

  trait MyPredicate[-T] {
    def test(elem: T): Boolean
  }

  trait MyTransformer[-A,B] {
    def transform(elem: A): B
  }

  val listOfIntegers: MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)


}
