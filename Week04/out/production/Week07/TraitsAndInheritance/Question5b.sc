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


trait Shape {
  def sides:Int
  def perimeter:Double
  def area:Double
}

trait Rectangular extends Shape{
  override  def sides = 4
}

class Circle(val radius: Double) extends Shape{
  def sides = 0
  def perimeter = 2 * math.Pi * radius
  def area = math.Pi * radius * radius
}

class Rectangle(val length: Double, val height: Double) extends Rectangular{
  def perimeter = 2*length + 2*height
  def area = length * height
}

class Square (val length: Double) extends Rectangular{
  def perimeter = sides * length
  def area = length * length
}

val mySquare = new Square(2.5)
val myRectangle = new Rectangle(2.5, 3)

mySquare.sides is 4
myRectangle.sides is 4

