package recursive.data.singly.linked.list

sealed trait IntList {

  def sum: Int = {
    this match {
      case End              => 0
      case Pair(heap, tail) => heap + tail.sum
    }
  }

  def length: Int = {
    this match {
      case End => 0
      case Pair(_, tail) => 1 + tail.length
    }
  }

  def product: Int = {
    this match {
      case End              => 1
      case Pair(heap, tail) => heap * tail.product
    }
  }

  def double: IntList = {
    this match {
      case End => this
      case Pair(heap, tail) => Pair(heap*2, tail.double)
    }
  }
}
case object End extends IntList
final case class Pair(heap: Int, tail: IntList) extends IntList

object main {
  def main(args: Array[String]): Unit = {
    val example = Pair(1, Pair(2, Pair(3, End)))

    println(example.double == Pair(2, Pair(4, Pair(6, End))))
    println(example.tail.double == Pair(4, Pair(6, End)))
    println(End.double == End)
  }

  def testProduct(): Unit = {
    val example = Pair(1, Pair(2, Pair(3, End)))

    println(example.product == 6)
    println(example.tail.product == 6)
    println(End.product == 1)
  }
  def testLength(): Unit = {
    val example = Pair(1, Pair(2, Pair(3, End)))

    println(example.length == 3)
    println(example.tail.length == 2)
    println(End.length == 0)
  }

  def testSum(): Unit = {
    val d = End
    val c = Pair(3, d)
    val b = Pair(2, c)
    val a = Pair(1, b)

    println(d.sum)
    println(c.sum)
    println(b.sum)
    println(a.sum)
  }
}