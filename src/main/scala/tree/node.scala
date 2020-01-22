package tree

sealed trait Tree {
  def sum: Int
  def double: Tree
}
case class Node(rightNode: Tree, leftNode: Tree) extends Tree {
  override def sum: Int = rightNode.sum + leftNode.sum
  override def double: Tree = Node (rightNode.double, leftNode.double)
}
case class Leaf(value: Int) extends Tree {
  override def sum: Int = value
  override def double: Tree = Leaf(value * 2)
}

case object TreeOperations {
  def sum(tree: Tree): Int = {
    tree match {
      case Leaf(value)               => value
      case Node(rightNode, leftNode) => sum(rightNode) + sum(leftNode)
    }
  }

  def double(tree: Tree): Tree = {
    tree match {
      case Leaf(value)               => Leaf(2 * value)
      case Node(rightNode, leftNode) => Node(double(rightNode), double(leftNode))
    }
  }
}


object Test {
  def main(args: Array[String]): Unit = {
    val aTree = Node(Node(Leaf(2), Leaf(1)), Leaf(5))

    // Pattern matching
    println(TreeOperations.sum(aTree))
    println(TreeOperations.double(aTree))

    // Polymorphism
    println(aTree.sum)
    println(aTree.double)
  }
}
