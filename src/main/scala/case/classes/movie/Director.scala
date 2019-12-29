package `case`.classes.movie

case class Director(firstName : String, lastName : String, yearOfBirth : Int) {
  def name() : String = firstName + " " + lastName
}

object Director {
  def older(firstDirector : Director, secondDirector : Director) : Director = if (firstDirector.yearOfBirth > secondDirector.yearOfBirth) secondDirector else firstDirector
}
