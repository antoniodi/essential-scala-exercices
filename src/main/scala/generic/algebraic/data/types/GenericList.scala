package generic.algebraic.data.types

sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

trait LinkedList[A] {

  def apply(position: Int): Result[A] = {
    this match {
      case Pair(heap, tail) => if (position == 0) Success( heap ) else tail(position - 1)
      case End() => Failure("Bad things happened")
    }
  }

  def viewList(): String = {
    this match {
      case Pair(heap, tail) => s"${heap.toString}, ${tail.viewList()}"
      case End() => ""
    }
  }

  def contains[A](value: A): Boolean = {
    this match {
      case Pair(heap, tail) => if ( value.equals(heap) ) { true } else tail.contains(value)
      case End() => false
    }
  }

  def length: Int = {
    this match {
      case Pair(_, tail) => 1 + tail.length
      case End() => 0
    }
  }
}

case class End[A]() extends LinkedList[A]
case class Pair[A](heap: A, tail: LinkedList[A]) extends LinkedList[A]


case object main {

  def main(args: Array[String]): Unit = {
//    exampleLength
//    exampleContains()

    val example2 = Pair(1, Pair(2, Pair(3, End())))
    println(example2(0) == 1)
    println(example2(1) == 2)
    println(example2(2) == 3)
    println(example2(10))
    try {
      example2(10)
      false
    } catch {
      case e: Exception => true
    }

  }

  private def exampleLength = {
    val stringList = Pair("Hola", Pair("bebe", Pair("sita", End())))
    println(stringList.length)
  }

  private def exampleContains() = {
    val example = Pair(1, Pair(2, Pair(3, End())))
    println(example.contains(3) == true)
    println(example.contains(4) == false)
    println(End().contains(0) == false)
    println(example.contains("not an Int"))
    example
  }
}