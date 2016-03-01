import scala.annotation.tailrec

@tailrec
def factorial(n: Int, result: Int = 1): Int =
  n match {
    case 0 => result
    case _ => factorial(n - 1, result * n)
  }

def product(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
  def iter(a: Int, result: Int): Int = {
    if (a>b) result
    else iter(a+1, result*f(a))
  }
  iter(a, 1)
}

def factorialUsingProduct(n:Int):Int = product((x:Int) => x)(1,n)

factorialUsingProduct(3)
factorial(3)
factorialUsingProduct(6)
factorial(6)

