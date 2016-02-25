case class myPair[A,B](one: A, two:B)
val pair = myPair[String, Int]("hi", 2)
pair.one
pair.two