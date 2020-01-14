package `trait`.shape

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color : Color
}

sealed trait Rectangular extends Shape {
  def width : Double
  def height : Double

  override val sides: Int = 4
  override val perimeter : Double = 2 * width + 2 * height
  override val area: Double = width * height
}

case class Rectangle(width: Double, height: Double, color: Color) extends Rectangular {
}

case class Square(side: Double, color: Color) extends Rectangular {
  val width: Double = side
  val height: Double = side
}

case class Circle(radius : Double, color: Color) extends Shape {
  val sides: Int = 1
  val perimeter: Double = 2 * math.Pi * radius
  val area: Double = math.Pi * radius
}