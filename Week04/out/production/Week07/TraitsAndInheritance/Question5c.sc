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


sealed trait Shape {
  def sides:Int
  def perimeter:Double
  def area:Double
}

trait Rectangular extends Shape{
  override  def sides = 4
}

case class Circle(val radius: Double) extends Shape{
  def sides = 0
  def perimeter = 2 * math.Pi * radius
  def area = math.Pi * radius * radius
}

case class Rectangle(val length: Double, val height: Double) extends Rectangular{
  def perimeter = 2*length + 2*height
  def area = length * height
}

case class Square (val length: Double) extends Rectangular{
  def perimeter = sides * length
  def area = length * length
}

//(i)
object Draw{
  def apply(arg:Shape): String =
    arg match {
      case Circle(n) => "A circle of radius " + n.toInt + "cm"
      case Rectangle (n,k) =>"A rectangle of width " + n.toInt + "cm and height " + k.toInt + "cm"
      case Square(n) => "A square with side length of " + n.toInt + "cm"
      case _ => "Shape not recognised"
    }

}

//(ii)
Draw(Circle(10)) is "A circle of radius 10cm"
Draw(Rectangle(3,4)) is "A rectangle of width 3cm and height 4cm"
Draw(Square(4)) is "A square with side length of 4cm"

//(iii)
//Compiler does not recognise any of the shapes when case is
//removed 
