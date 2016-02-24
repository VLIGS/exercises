
sealed trait LinkedList[A]{
  def length():Int
  //def apply(list:LinkedList[A])
}
case class Empty[A]() extends LinkedList[A]{
  override def length():Int = 0
}
case class Pair[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]{
  override def length ():Int = 1 + tail.length()
}
val list: LinkedList[Int] =  Pair(1, Pair(2, Pair(3, Empty())))
list.isInstanceOf[LinkedList[Int]]
//list.head      // returns 1 as an Int
//list.tail.head // returns 2 as an Int
//list.tail.tail // returns Pair(3, Empty()) as a LinkedList[Int]

println(list.length())
