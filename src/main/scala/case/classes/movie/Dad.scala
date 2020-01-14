package `case`.classes.movie

object Dad {
  def rate(aFilm : Film): Double = {
    aFilm match {
      case Film(_, _, _, Director("Clint", "Eastwood", _)) => 10.0
      case Film(_, _, _, Director("John", "McTiernan", _)) => 7.0
      case _ => 3.0
    }
  }
}
