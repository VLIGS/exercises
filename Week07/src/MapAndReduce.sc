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

// /Question 1(a)
val v = Vector(1, 2, 3, 4)

v.map(n => n*11+10) is Vector(21, 32, 43, 54)

//Question 1(b)

//This doesn't work, test fails
//val v1 = Vector(1, 2, 3, 4)
//v1.foreach(n => n*11+10) is Vector(21, 32, 43, 54)

//Question 1(c)
var v1 = Vector(1, 2, 3, 4)
for (i <- 0 until v1.length)
  v1:+(v1(i) * 11 + 10)

println(v1)

//v2 is Vector(21, 32, 43, 54)