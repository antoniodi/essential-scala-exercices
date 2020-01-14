package `trait`.shape

object Draw {
  def apply(shape : Shape) : String = {
    shape match {
      case Rectangle(width, height, color) => s"A ${Draw.apply(color)} rectangle of width ${width}cm and height ${height}cm"
      case Square(side, color) => s"A ${Draw.apply(color)} square of side ${side}cm"
      case Circle(radius, color) => s"A ${Draw.apply(color)} circle of radius ${radius}cm"
    }
  }

    def apply(color: Color): String = color match {
      // We deal with each of the predefined Colors with special cases:
      case Red    => "red"
      case Yellow => "yellow"
      case Pink   => "pink"
      case color  => if(color.isLight) "light" else "dark"
    }
}
