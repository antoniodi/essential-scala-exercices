package companion.movie

class Director(val firstName : String, val lastName : String, val yearOfBirth : Int) {
  def name() : String = firstName + " " + lastName
  def copy(firstName : String = this.firstName, lastName : String  = this.lastName, yearOfBirth : Int = this.yearOfBirth) = new Director(firstName, lastName, yearOfBirth)

}

object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int): Director = new Director(firstName, lastName, yearOfBirth)
  def older(firstDirector : Director, secondDirector : Director) : Director = if (firstDirector.yearOfBirth > secondDirector.yearOfBirth) secondDirector else firstDirector
}
