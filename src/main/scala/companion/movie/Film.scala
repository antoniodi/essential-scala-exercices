package companion.movie

import java.time.LocalDate

class Film(val name : String, val yearOfRelease : Int, val imdbRating : Double, val director : Director) {
  def directorsAge : Int = director.yearOfBirth - yearOfRelease
  def isDirectedBy(director: Director) : Boolean = director == this.director
  def copy(name : String = this.name, yearOfRelease : Int = this.yearOfRelease, imdbRating : Double = this.imdbRating, director : Director = this.director) = new Film(name, yearOfRelease, imdbRating, director)
}

object Film {
  def apply(name: String, yearOfRelease: Int, imdbRating: Double, director: Director): Film = new Film(name, yearOfRelease, imdbRating, director)
  def highestRating(firstFilm : Film, secondFilm : Film) : Double = if (secondFilm.imdbRating > firstFilm.imdbRating) secondFilm.imdbRating else firstFilm.imdbRating
  def oldestDirectorAtTheTime(firstFilm : Film, secondFilm : Film) : Director = if (firstFilm.yearOfRelease > secondFilm.yearOfRelease) secondFilm.director else firstFilm.director

}
