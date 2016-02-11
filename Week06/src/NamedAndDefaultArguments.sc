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


//Question 6

//define class with two member fields
class SimpleTime(val hours: Int, val minutes: Int)

//instantiate class giving values to its fields
val t = new SimpleTime(hours=5, minutes=30)

t.hours is 5
t.minutes is 30

//Question 7

//define class with two member fields with one of the fields
//instantiated to default value which is used if no value is provided
class SimpleTime2(val hours: Int, val minutes: Int = 0)

val t2 = new SimpleTime2(hours=10)
t2.hours is 10
t2.minutes is 0

//Question 8

class Planet(val name:String, val description: String, val moons: Int = 1){
  def hasMoon = {
    if(moons>0) true else false
  }
}

val p = new Planet(name = "Mercury",
  description = "small and hot planet", moons = 0)

p.hasMoon is false

//Question 9

val earth = new Planet(moons = 1, name = "Earth",
  description = "a hospitable planet")
earth.hasMoon is true

//Question 10

class Item(val name: String, val price: Double){
  def cost(grocery: Boolean = false, medication: Boolean = false,
           taxRate:Double = 0.10) = {
    if(grocery||medication) price else price + price * taxRate
  }
}

val flour = new Item(name="flour", 4)
flour.cost(grocery=true) is 4
val sunscreen = new Item(name="sunscreen", 3)
sunscreen.cost() is 3.3
val tv = new Item(name="television", 500)
tv.cost(taxRate = 0.06) is 530
