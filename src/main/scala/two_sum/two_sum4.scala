package two_sum

import scala.collection.mutable

class TreeNode(_value: Int) {
  var value: Int = _value
  var left: TreeNode = null
  var right: TreeNode = null
}

object two_sum4 {

  def help(node: TreeNode, k: Int, values: mutable.Set[Int]): Boolean = {
    node match {
      case n if n == null => false
      case s if values.contains(k - s.value) => true
      case r =>
        values += r.value
        help(r.left, k, values) || help(r.right, k, values)
    }
  }

  def findTarget(root: TreeNode, k: Int): Boolean = {
    val values = scala.collection.mutable.Set[Int]()

    help(root, k, values)
  }

  def main(args: Array[String]): Unit = {
    val tree1: TreeNode = new TreeNode(5)
    val tree2: TreeNode = new TreeNode(3)
    val tree3: TreeNode = new TreeNode(6)
    val tree4: TreeNode = new TreeNode(2)
    val tree5: TreeNode = new TreeNode(4)
    val tree6: TreeNode = new TreeNode(7)

    tree1.left = tree2
    tree1.right = tree3

    tree2.left = tree4
    tree2.right = tree5

    tree3.right = tree6

    val result = findTarget(tree1, 28)

    if (result) println("Yes")
    else println("No")

  }

}
