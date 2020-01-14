import `case`.classes.cat.{Cat, ChipShop}
import `trait`.shape.{Circle, CustomColor, Draw, Pink, Rectangle, Square, Yellow}
import companion.`object`.Person
import counter.exercise.Counter

object main {

  def main(args: Array[String]): Unit = {
    sealedTrait()
  }

  def sealedTrait(): Unit = {
    println(Draw(Rectangle(4, 3, Yellow)))
    println(Draw(new Square(3, CustomColor(100,20,150))))
    println(Draw(new Square(3, Pink)))
    println(Draw(Circle(2, Yellow)))

  }

  def  patternMatching() = {
    val aCat1 = Cat("blue", "milk")
    val aCat2 = Cat("green", "chips")
    println(ChipShop.willServe(aCat1))
    println(ChipShop.willServe(aCat2))
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
