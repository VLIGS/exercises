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

// Question 12

class ClothesWasher{
  var modelName = ""
  var capacity = 0.0
  def this(modelName: String){
    this()
    this.modelName = modelName
  }
  def this(capacity: Double){
    this()
    this.capacity = capacity
  }
}

val cw = new ClothesWasher
cw.modelName is ""
cw.capacity is 0.0

val cw1 = new ClothesWasher("Bosh")
cw1.modelName is "Bosh"
cw1.capacity is 0.0

val cw2 = new ClothesWasher(5.6)
cw2.modelName is ""
cw2.capacity is 5.6

// Question 13

class ClothesWasher2(val modelName: String ="Bosh",
                     val capacity: Double = 5.6)
val cl = new ClothesWasher2

cl.modelName is "Bosh"
cl.capacity is 5.6
