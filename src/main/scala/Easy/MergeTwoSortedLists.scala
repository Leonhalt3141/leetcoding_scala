package Easy


class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object MergeTwoSortedLists {

  def mergeTwoLists2(l1: ListNode, l2: ListNode): ListNode = {
    val head = new ListNode()
    var current = head
    var l1cur = l1
    var l2cur = l2
    while (l1cur != null || l2cur != null) {
      if (l1cur == null || (l2cur != null && l1cur.x > l2cur.x)) {
        // use commented portion to allocate new instead
        // of copying references
        //current.next = new ListNode(l2cur.x)
        current.next = l2cur
        l2cur = l2cur.next
      } else {
        //current.next = new ListNode(l1cur.x)
        current.next = l1cur
        l1cur = l1cur.next
      }
      current = current.next
    }
    head.next
  }

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = (l1, l2) match {
    case (null, null) => null
    case (a, b) if a != null && b == null => a
    case (a, b) if a == null && b != null => b
    case (a, b) if a != null && b != null => {
      if (a.x <= b.x) {
        a.next = mergeTwoLists(a.next, b)
        a
      } else {
        b.next = mergeTwoLists(a, b.next)
        b
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val n1 = new ListNode(1)
    n1.next = new ListNode(2)
    n1.next.next = new ListNode(4)

    val n2 = new ListNode(1)
    n2.next = new ListNode(3)
    n2.next.next = new ListNode(4)

    val n3 = mergeTwoLists2(n1, n2)

    println(n3.x)
    println(n3.next.x)
    println(n3.next.next.x)
    println(n3.next.next.next.x)
    println(n3.next.next.next.next.x)
  }
}
