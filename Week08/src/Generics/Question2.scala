package Generics

sealed trait IntList {

  def foldInt(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End => end
      case Pair(hd, tl) => f(hd, tl.foldInt(end, f))
    }

  def length1: Int = this.foldInt(0, (sum, _) => sum + 1)

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

  def product1: Int = this.foldInt(1, _ * _)

  def product: Int =
  this match {
  case End => 1
  case Pair(hd, tl) => hd * tl.product
  }
  def sum1: Int = this.foldInt(0, _ + _)

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

//Question 2c
//It is more convenient to rewrite methods in terms of fold if they were implemented using pattern matching
//rather than polymorphism. This is due to the fact that the methods need to be rewritten only once, rather
//than as many times as there are case classes that extend trait if IntList was implemented using polymorphism.
//Pattern Matching can be used here because we know all of the subclasses, so we can spell out all cases in match sequence


//Question 2d
//Double method does not fit the pattern that sum, product, and length have, in particular, it returns IntList
//rather than just Int



