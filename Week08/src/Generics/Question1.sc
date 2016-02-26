sealed trait LinkedList[A]{
  def isEmpty: Boolean
  def head: A
  def tail: LinkedList[A]
  def length: Int
}
case class End[A]() extends LinkedList[A]{
  def isEmpty = true
  def head = throw new NoSuchElementException
  def tail = throw new NoSuchElementException
  def length():Int = 0
}
case class Pair[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]{
  def isEmpty = false
  override def length ():Int = 1 + tail.length
}
val example1 = Pair(1, Pair(2, Pair(3, End())))
example1.length()
example1.tail.length
End().length