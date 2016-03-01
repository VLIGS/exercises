import scala.annotation.tailrec

def product(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
  def iter(a: Int, result: Int): Int = {
    if (a>b) result
    else iter(a+1, result*f(a))
  }
  iter(a, 1)
}
product((x:Int) => x)(1, 3)
product((x:Int) => x*x)(1, 3)