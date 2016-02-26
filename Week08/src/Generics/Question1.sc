sealed trait LinkedList[A]
case class End[A]() extends LinkedList[A]
case class Pair[A](val head: A, val tail: LinkedList[A]) extends