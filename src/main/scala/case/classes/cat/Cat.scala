package `case`.classes.cat

case class Cat(color : String, food : String)

object ChipShop {
  def willServe(cat : Cat): Boolean = {
    cat match {
      case Cat(_, "chips") => true
      case _ => false
    }
  }
}