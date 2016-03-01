//Question 5(a)

trait Shape {
  def sides:Int
  def perimeter:Double
  def area:Double
}

class Circle(val radius: Double) extends Shape{
  def sides = 0
  def perimeter = 2 * math.Pi * radius
  def area = math.Pi * radius * radius
}

class Rectangle(val length: Double, val height: Double) extends Shape{
  def sides = 4
  def perimeter = 2*length + 2*height
  def area = length * height
}

class Square (val length: Double) extends Shape{
  def sides = 4
  def perimeter = sides * length
  def area = length * length
}

val s1 = new Square(2.5)
s1.length