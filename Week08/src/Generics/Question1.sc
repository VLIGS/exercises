sealed trait LinkedList[A]{
  def isEmpty: Boolean
  def head: A
  def tail: LinkedList[A]
  def length: Int
  def contains(item:A): Boolean
  def apply(n:Int):A
}
case class End[A]() extends LinkedList[A]{
  def isEmpty = true
  def head = throw new NoSuchElementException
  def tail = throw new NoSuchElementException
  def length():Int = 0
  def contains(item:A):Boolean = false
  def apply(n:Int):A = throw new IndexOutOfBoundsException
}
case class Pair[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]{
  def isEmpty = false
  def length ():Int = 1 + tail.length
  def contains(item:A):Boolean = {
    if (head.equals(item)) true else tail.contains(item)
  }
  def apply(n:Int):A = {
    if (this.isEmpty) throw new IndexOutOfBoundsException
    else if (n == 0) head
    else tail.apply(n - 1)
  }
}

val example1 = Pair(1, Pair(2, Pair(3, End())))
//Testing Question 1b
example1.length()
example1.tail.length
End().length
//Testing Question 1c
example1.contains(3)
example1.contains(4)
End().contains(0)

//Testing Question 1d
example1.apply(0)
example1.apply(1)
example1.apply(2)