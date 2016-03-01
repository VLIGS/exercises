sealed trait Shape {
  var colour:Colour
  def sides:Int
  def perimeter:Double
  def area:Double
}

trait Rectangular extends Shape{
  override  def sides = 4
}

case class Circle(val radius: Double, var colour:Colour) extends Shape{
  def sides = 0
  def perimeter = 2 * math.Pi * radius
  def area = math.Pi * radius * radius
}

case class Rectangle(val length: Double, val height: Double, var colour:Colour) extends Rectangular{
  def perimeter = 2*length + 2*height
  def area = length * height
}

case class Square (val length: Double, var colour:Colour) extends Rectangular{
  def perimeter = sides * length
  def area = length * length
}

//(i)
object Draw{
  def apply(arg:Shape): String =
    arg match {
      case Circle(n, c )=> "A " + c.printColour + " circle of radius " + n.toInt + "cm"
      case Rectangle (n,k,c) =>"A " + c.printColour + " rectangle of width " + n.toInt + "cm and height " + k.toInt + "cm"
      case Square(n,c) => "A " + c.printColour + " square with side length of " + n.toInt + "cm"
      case _ => "Shape not recognised"
    }
}
sealed trait Colour{
  val R:Int
  val G:Int
  val B:Int
  def printColour:String
  def checkIfDarkOrLight:String = if ((R+G+B)<300) "dark" else "light"

}
case class Red()extends Colour{
  val R = 255
  val G = 0
  val B = 0
  override def printColour = "red"
}
case class Yellow()extends Colour{
  val R = 255
  val G = 255
  val B = 0
  override def printColour = "yellow"
}
case class Pink() extends Colour{
  val R = 255
  val G = 153
  val B = 204
  override def printColour = "pink"
}
case class CustomColour(val R: Int, val G: Int, val B:Int) extends Colour{
  override def printColour = checkIfDarkOrLight
}

println(Draw(Circle(10, Pink()))) // prints: A pink circle of radius 10cm
println(Draw(Square(10, CustomColour(255,153,51)))) // prints A light square with side length of 10cm
