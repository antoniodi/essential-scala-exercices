package `case`.classes.movie

case class Film(name: String, yearOfRelease: Int, imdbRating: Double, director: Director) {
  def directorsAge : Int = director.yearOfBirth - yearOfRelease
  def isDirectedBy(director: Director) : Boolean = director == this.director
}

object Film {
  def highestRating(firstFilm : Film, secondFilm : Film) : Double = if (secondFilm.imdbRating > firstFilm.imdbRating) secondFilm.imdbRating else firstFilm.imdbRating
  def oldestDirectorAtTheTime(firstFilm : Film, secondFilm : Film) : Director = if (firstFilm.yearOfRelease > secondFilm.yearOfRelease) secondFilm.director else firstFilm.director
}

