package Generics

sealed trait IntList {

  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def length1: Int = this.fold(0, (sum, _) => sum + 1)

  def length: Int =
    this match {
      case End => 0
      case Pair(hd, tl) => 1 + tl.length
    }

  def double: IntList =
    this match {
      case End => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }

  def product1: Int = this.fold(1, _ * _)

  def product: Int =
  this match {
  case End => 1
  case Pair(hd, tl) => hd * tl.product
  }
  def sum1: Int = this.fold(0, _ + _)

  def sum: Int =
  this match {
  case End => 0
  case Pair(hd, tl) => hd + tl.sum
  }
}

case object End extends IntList
case class Pair(head: Int, tail: IntList) extends IntList

object MyMain extends App {
  val myList: IntList = Pair(1, Pair(2, Pair(3, End)))
  println(myList.length)
  println(myList.length1)
  println(myList.product)
  println(myList.product1)
  println(myList.sum)
  println(myList.sum1)
}