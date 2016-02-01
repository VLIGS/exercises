class Cup {
  var percentFull = 0
  val max = 100
  val min = 0
  def set(newValue:Int): Unit = {
    percentFull = newValue
  }

  def get(): Int = {
    percentFull
  }

  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    }
    else if(percentFull<min){
      percentFull = min
    }
    percentFull // Return this value
  }
}

import java.io.FileWriter

import scala.language.implicitConversions

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

val cup = new Cup
cup.add(45) is 45
cup.add(-15) is 30
cup.add(-50) is 0

val cup1 = new Cup
cup1.add(45) is 45
cup1.add(-55) is 0
cup1.add(10) is 10
cup1.add(-9) is 1
cup1.add(-2) is 0

val cup2 = new Cup
cup2.percentFull = 56
cup2.percentFull is 56

val cup3 = new Cup
cup3.set(56)
cup3.get() is 56