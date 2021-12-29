package lectures.part3fp

object L4 extends App {

  val list = List(1, 2, 3)
  println(list)

  // Map: apply function to each element of A, returning a type A
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // Filter: check condition for each element of A, returning a type A
  println(list.filter(_ % 2 == 0))

  // FlatMap: applies function to each element of A and then flattens it, returning a type A
  val toPair: (Int => List[Int]) = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // Exercise: print all combinations between two lists,
  // i.e., List("a1", "a2", ..., "d3", "d4)
  val numbers = List(1, 2, 3, 4)
  val characters = List('a', 'b', 'c', 'd')

  // notice how 2 loops = flatMap + map
  val num_char_comb: List[String] =
    characters.flatMap(x => numbers.map(y => x.toString + y.toString))
  println(num_char_comb)

  //notice how 3 loops = flatMap + flatMap + map
  val colors = List("black", "white")
  val num_char_col_comb: List[String] = {
    characters.flatMap(c =>
      numbers.flatMap(n => colors.map(col => c.toString + n.toString + col))
    )
  }
  println(num_char_col_comb)

  // Foreach: similar to map, but receives a function returning Unit
  list.foreach(println)

  // Note: flatMap and map chains get harder and harder to read
  // Solution: for-comprehension
  val forCombinations = for {
    n <- numbers
    c <- characters
    col <- colors
  } yield c.toString + n.toString + col
  println(forCombinations)

  // We can use filters within for-comprehensions with the so-called "guards"
  val forCombinationsWithGuards = for {
    n <- numbers if n % 2 == 0
    c <- characters
    col <- colors
  } yield c.toString + n.toString + col
  println(forCombinationsWithGuards)

  // We can also use side effects (return unit) with for-comprehensions
  for {
    n <- numbers
  } println(n)


  /*
   Exercises:
   - A small collection of at most one element
   */



}
