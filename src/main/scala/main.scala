import companion.`object`.Person
import counter.exercise.Counter

object main {

  def main(args: Array[String]): Unit = {
  }

  def  companionObject() = {
  }

  def companionObjectExercise(): Unit = {
    val aPerson = Person("Antonio Cortes")
    print(aPerson.firstName+ " " +aPerson.lastName)
  }

  def counterExercise(): Unit = {
    println(new Counter(10).inc().dec().inc().inc().count)
    println(new Counter(10).inc.inc(10).count)
  }

}
