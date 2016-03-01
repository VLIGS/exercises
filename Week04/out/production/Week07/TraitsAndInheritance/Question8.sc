
sealed trait LinkedList[A]
case class Pair[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]
case class Empty[A]() extends LinkedList[A]


val list =  Pair(1, Pair(2, Pair(3, Empty())))
list.isInstanceOf[LinkedList[Int]]
list.head
list.tail.head
list.tail.tail