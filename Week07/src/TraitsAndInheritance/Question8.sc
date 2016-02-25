
sealed trait LinkedList[A]{
  def length():Int
  //def apply(element:Int): A
  def contains(item:A):Boolean
}
case class Empty[A]() extends LinkedList[A]{
  override def length():Int = 0
  //override def apply(element:Int): A = Nil
  override def contains(item:A):Boolean = false
}
case class Pair[A](val head: A, val tail: LinkedList[A]) extends LinkedList[A]{
  override def length ():Int = 1 + tail.length()
  //override def apply(element:Int): A = {}
  override def contains(item:A):Boolean = {
    if (head.equals(item)) true else tail.contains(item)
  }

}
val list: LinkedList[Int] =  Pair(1, Pair(2, Pair(3, Empty())))
list.isInstanceOf[LinkedList[Int]]
//list.head      // returns 1 as an Int
//list.tail.head // returns 2 as an Int
//list.tail.tail // returns Pair(3, Empty()) as a LinkedList[Int]

//testing 8b(i)
println(list.length())

//testing 8b(iii)
println(list.contains(1))
println(list.contains(2))
println(list.contains(3))
println(list.contains(4))

