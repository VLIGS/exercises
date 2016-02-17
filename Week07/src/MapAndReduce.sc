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
var v2 = new Array[Int](v1.length)

for (i <- 0 until v1.last)
  v2(i) = v1(i) * 11 + 10

v1 = v2.toVector
v1 is Vector(21, 32, 43, 54)

//Question 2

var v3 = Vector(1, 2, 3, 4)
var v4 = new Array[Int](v3.length)
for (i <- 0 until v3.last)
  v4(i) = v3(i) + 1

v3 = v4.toVector
v3 is Vector(2,3,4,5)

//Question 3

val v5 = Vector(1, 10, 100, 1000)
var sum = 0
for (i <- 0 until v5.length)
  sum = sum + v5(i)

sum is 1111

//Question 4
def sumIt(args: Int*): Int = args.reduce(( sum1, n) => sum1 + n)
sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195




