import java.io.FileWriter

class AtomicTest[T](val target: T) {
  val errorLog = "_AtomicTestErrors.txt"

  def tst[E](expected: E)(test: => Boolean) {
    println(target)
    if (test == false) {
      val msg = "[Error] expected:\n" +
        expected
      println(msg)
      val el = new FileWriter(errorLog, true)
      el.write(target + msg + "\n")
      el.close()
    }
  }

  def str = // Safely convert to a String
    Option(target).getOrElse("").toString

  def is(expected: String) = tst(expected) {
    expected.replaceAll("\r\n", "\n") == str
  }

  def is[E](expected: E) = tst(expected) {
    expected == target
  }

  def beginsWith(exp: String) = tst(exp) {
    str.startsWith(
      exp.replaceAll("\r\n", "\n"))
  }
}

object AtomicTest {
  implicit def any2Atomic[T](target: T) =
    new AtomicTest(target)
}

import AtomicTest._

//Question 21

val dogYears = (x:Int) => x * 7
dogYears(10) is 70

//Question 22

var s = ""
val v = Vector(1, 5, 7, 8)
v.foreach(s += dogYears( _) + " ")

s is "7 35 49 56 "

//Question 23

val numSq = (x:Int) => x * x
var s1 = ""
val numbers = Vector(1, 2, 5, 3, 7)
numbers.foreach(s1 += numSq( _)+ " ")
s1 is "1 4 25 9 49 "