sealed trait Maybe[A]
case class Full[A](value:A) extends Maybe[A]
case class Empty[A]() extends Maybe[A]


