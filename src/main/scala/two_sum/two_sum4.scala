package two_sum

import scala.collection.mutable

class TreeNode(_value: Int) {
  var value: Int = _value
  var left: TreeNode = _
  var right: TreeNode = _
}

object two_sum4 {

  def help(node: TreeNode, k: Int, values: mutable.Set[Int]): Boolean = {
    node match {
      case a if a == null => false
      case b if values.contains(k - b.value) =>
        true
      case c =>
        values += c.value
        help(c.left, k, values) || help(c.right, k, values)
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

    val result = findTarget(tree1, 9)

    if (result) println("Yes")
    else println("No")

  }

}
