
package Generics

sealed trait myList[A] {
/**
  def fold(end: A)(f: (A, A) => A): myList [A] =
    this match {
      case myEnd() => this
      case myPair(hd, tl) => f(hd)( tl.fold(end, f))
    }

  def length1: myList[A] = this.fold(0)( (sum, _) => sum + 1)

  def length: Int =
    this match {
      case myEnd() => 0
      case myPair(hd, tl) => 1 + tl.length
    }

  def double: myList[A] =
    this match {
      case myEnd() => this
      case myPair(hd, tl) => myPair(hd * 2, tl.double)
    }

  def product1: Int = this.fold(1)( _ * _)

  def product: Int =
    this match {
      case myEnd() => 1
      case myPair(hd, tl) => hd * tl.product
    }
  def sum1: Int = this.fold(0)( _ + _)

  def sum: Int =
    this match {
      case myEnd() => 0
      case myPair(hd, tl) => hd + tl.sum
    }
  **/
}
case class myEnd() extends myList [Nothing]
case class myPair[A](val head: A, val tail: myList[A]) extends myList [A]

object MyListMain extends App {
  val myList: IntList = Pair(1, Pair(2, Pair(3, End)))
  println(myList.length)
  println(myList.length1)
  println(myList.product)
  println(myList.product1)
  println(myList.sum)
  println(myList.sum1)
}





