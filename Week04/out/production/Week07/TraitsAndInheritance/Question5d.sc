//(i)
sealed trait Colour{
  val R:Int
  val G:Int
  val B:Int
  def checkIfDarkOrLight:String = if ((R+G+B)<300) "dark" else "light"
}

//(ii)
class Red()extends Colour{
  val R = 255
  val G = 0
  val B = 0
}

class Yellow()extends Colour{
  val R = 255
  val G = 255
  val B = 0
}
class Pink()extends Colour{
  val R = 255
  val G = 153
  val B = 204
}

//(iii)
class CustomColour(val R: Int, val G: Int, val B:Int) extends Colour
val orange = new CustomColour(255,153,51)
println("Colour orange has RGB color code: " + orange.R + ":" + orange.G + ":" + orange.B )

//(iv)
println("Colour orange is " + orange.checkIfDarkOrLight + " colour")
