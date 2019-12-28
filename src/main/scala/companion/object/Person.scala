package companion.`object`

class Person(val firstName : String, val lastName : String) {
}

object Person {
  def apply(fullName : String): Person = {
    val nameAndLastName = fullName.split(" ")
    new Person(nameAndLastName(0), nameAndLastName(1))
  }
}
