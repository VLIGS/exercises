import scala.annotation.tailrec

//recursive functions could cause stack overflow errors
//for large collections because each recursive call adds
//another layer to the stack
//this problem can be resolved for methods that are tail
//recursive - calls itself at the end of one of its branches
//the function itself has to be marked final in order to be able
//to use tail recursive annotation
//efficiency comes from the reuse of current stack frame
//instead of creating a new one at each recursive call
//hence, stack never grows higher

def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

@tailrec
def factorial1(n: Int, result: Int = 1): Int =
  n match {
    case 0 => result
    case _ => factorial1(n - 1, result * n)
  }

factorial(3)
factorial1(3)