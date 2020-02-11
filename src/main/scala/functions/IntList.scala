package functions

trait IntList {

  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End() => end
      case Pair(head, tail) => f(head, tail.fold(end, f))
    }

  def sum: Int = {
    this.fold[Int](0, (head, tail) => head + tail)
  }

  def length: Int = {
    this.fold[Int](0, (_, tail) => 1 + tail)
  }

  def product: Int = {
    this.fold[Int](1, (head, tail) => head * tail)
  }

  def double: IntList = {
    this.fold[IntList](End(), (head, tail) => Pair(head * 2, tail) )
  }

}

case class End() extends IntList
case class Pair( heap: Int, tail: IntList ) extends IntList

object main {

  def main(args: Array[String]): Unit = {
    val intList = Pair(10, Pair(15, Pair(7, Pair(2, End()))))

    println(intList.sum)
    println(intList.product)
    println(intList.length)
    print(intList.double)
  }
}
