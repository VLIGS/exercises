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

//Vectors
//1.Vectors, each populated by a different type of data
val myStringVector = Vector("one","two","three")
val myMixVector = Vector("one", 2, 3.0)

//2. Make a Vector containing other Vectors
val myVectorsVector = Vector(myStringVector,myMixVector)

//3. Create a Vector and populate it with words
val myVector = Vector("The ","dog ","visited ", "the ", "fire ", "station ")

for (i <- 0 until myVector.length)
  print(myVector(i))

val sentence = myVector.mkString
sentence is "The dog visited the fire station "

//4. Create and initialise two Vectors, one containing Ints and one containing Doubles.
//Call the sum, min, and max operations on each one.
val myIntVector = Vector(1,2,3)
val myDoubleVector = Vector(1.0, 2.0, 3.0)
myIntVector.max
myIntVector.min
myIntVector.sum

myDoubleVector.max
myDoubleVector.min
myDoubleVector.sum

//5. Create two Vectors of Int named myVector1 and myVector2, each initialised to
//1, 2, 3, 4, 5, 6. Use AtomicTest to show whether the two are equivalent
val myIntVector1 = Vector(1,2,3,4,5,6)
val myIntVector2 = Vector(1,2,3,4,5,6)
myIntVector1 is myIntVector2