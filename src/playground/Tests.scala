package playground

import scala.annotation.tailrec

object Tests extends App {

  val num = 3

  var aList: List[Int] = List(1,3,4,5)
  println(aList.map(x => List.fill(num)(x)).flatten)

}
