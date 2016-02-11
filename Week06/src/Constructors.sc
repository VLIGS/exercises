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


//Question 11

class Tea (
  val name: String = "Earl Grey",
  val decaf: Boolean = false,
  val milk: Boolean = false,
  val sugar: Boolean = false)
{
  def describe = {
    if(decaf) if(milk ) if(sugar) name + " decaf" + " + milk" + " + sugar" else name + " decaf" + " + milk"
              else if (sugar) name + " decaf" + " + sugar" else name + " decaf"
    else if (milk) if (sugar) name + " + milk" + " + sugar" else name + " + milk"
    else if (sugar) name + " + sugar" else name
  }

  def calories ={
    if(milk ) if(sugar) 100 + 16 else 100
    else if (sugar) 16
    else 0
  }
}

val tea = new Tea
tea.describe is "Earl Grey"
tea.calories is 0

val lemonZinger = new Tea(decaf = true, name="Lemon Zinger")
lemonZinger.describe is "Lemon Zinger decaf"
lemonZinger.calories is 0

val sweetGreen = new Tea(name="Jasmine Green", sugar=true)
sweetGreen.describe is "Jasmine Green + sugar"
sweetGreen.calories is 16

val teaLatte = new Tea(sugar=true, milk=true)
teaLatte.describe is "Earl Grey + milk + sugar"
teaLatte.calories is 116

