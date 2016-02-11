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

//3
class Family(members: String*){
  val familyMembers = for (mem <- members) yield mem
  def familySize() = familyMembers.length
}

val family1 = new Family("Mum", "Dad", "Sally", "Dick")
family1.familySize() is 4
val family2 = new Family("Dad", "Mom", "Harry")
family2.familySize() is 3

//4
class FlexibleFamily(members: String*){
  val parents = for (i <- 0 to 1) yield members(i)
  val children = for (i <- 2 to members.length-1) yield members(i)
  def familySize() = parents.length + children.length
}

val family3 = new FlexibleFamily("Mum", "Dad", "Sally", "Dick")
family3.familySize() is 4
val family4 = new FlexibleFamily("Dad", "Mom", "Harry")
family4.familySize() is 3

//5
def squareThem(args: Int*) = {
  var result = 0
  for (arg <- args) result = result + arg*arg
  result
}
squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21
