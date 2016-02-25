sealed trait Maybe[A]
case class Full[A](value:A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]

case object divide{
  def apply(arg1: Int, arg2:Int):Maybe[Int] = if (arg2 == 0) Empty() else Full(arg1/arg2)
}

divide(1, 0) match {
  case Full(value) => println(s"It's finite: ${value}")
  case Empty()     => println(s"It's infinite")
}

divide(1, 2) match {
  case Full(value) => println(s"It's finite: ${value}")
  case Empty()     => println(s"It's infinite")
}

divide(2, 1) match {
  case Full(value) => println(s"It's finite: ${value}")
  case Empty()     => println(s"It's infinite")
}

