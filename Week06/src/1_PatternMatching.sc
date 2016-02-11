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


//Question 1
def forecast(value: Int): String = value match {
  case 100 => "Sunny"
  case 80 => "Mostly Sunny"
  case 50 => "Partly Sunny"
  case 20 => "Mostly Cloudy"
  case 0 => "Cloudy"
  case _ => "Unknown"
}

  forecast(100) is "Sunny"
  forecast(80) is "Mostly Sunny"
  forecast(50) is "Partly Sunny"
  forecast(20) is "Mostly Cloudy"
  forecast(0) is "Cloudy"
  forecast(15) is "Unknown"

//Question 2
val sunnyData = Vector(100,80,50,20,0,15)

for (i <- 0 until sunnyData.length)
  print(forecast(sunnyData(i)) + "\n")
