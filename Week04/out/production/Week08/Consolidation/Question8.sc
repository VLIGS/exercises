import scala.annotation.tailrec

def product(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
  def iter(a: Int, result: Int): Int = {
    if (a>b) result
    else iter(a+1, result*f(a))
  }
  iter(a, 1)
}

def sum(f: Int => Int)(a: Int, b: Int): Int = {
  @tailrec
  def iter(a: Int, result: Int): Int = {
    if (a>b) result
    else iter(a+1, result+f(a))
  }
  iter(a, 0)
}

def generalF(f: Int => Int)(seed: Int, g:(Int, Int)=> Int)(a: Int, b: Int): Int = {
  @tailrec
  def iter(a: Int, result: Int): Int = {
    if (a>b) result
    else iter(a+1, g(result,f(a)))
  }
  iter(a, seed)
}

def sumAsGeneralF (f: Int => Int)(a: Int, b: Int): Int =
  generalF(f)(0, (x:Int, y:Int) => x+y)(a, b)

def productAsGeneralF (f: Int => Int)(a: Int, b: Int): Int =
  generalF(f)(1, (x:Int, y:Int) => x*y)(a, b)

sum((x:Int) => x*x)(1, 3)
sumAsGeneralF((x:Int) => x*x)(1, 3)

product((x:Int) => x*x)(1, 3)
productAsGeneralF((x:Int) => x*x)(1, 3)