package `trait`.shape

sealed trait Color {
  def red : Int
  def green : Int
  def blue : Int

  def isLight : Boolean = if(red + blue + green < 375) false else true
}

case class CustomColor(red: Int, green: Int, blue: Int) extends Color

object Yellow extends Color {
  override def red: Int = 125
  override def green: Int = 125
  override def blue: Int = 125
}

object Red extends Color {
  override def red: Int = 200
  override def green: Int = 125
  override def blue: Int = 125
}

object Pink extends Color {
  override def red: Int = 190
  override def green: Int = 125
  override def blue: Int = 125
}