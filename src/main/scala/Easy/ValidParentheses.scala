package Easy

import scala.collection.mutable.Stack

object ValidParentheses {
  /*
    EASY
    https://leetcode.com/problems/valid-parentheses/
    Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
   */


  def isValid(s: String): Boolean = {

    val mapping = Map(
      ')' -> '(',
      ']' -> '[',
      '}' -> '{'
    )

    //noinspection ScalaDeprecation,ReferenceMustBePrefixed
    val stack = new Stack[Char]

    for (i <- 0 until s.length) {
      val c = s.charAt(i)

      if (mapping.keySet.contains(c)) {
        val topElement: Char = if (stack.isEmpty) '#' else stack.pop()
        val v = mapping(c)

        if (topElement != v) return false


      } else {
        stack.push(c)
      }
    }
    stack.isEmpty
  }


  def main(args: Array[String]): Unit = {
    val s1 = "()"
    println(1, s1, isValid(s1))
    println()

    val s2 =  "()[]{}"
    println(2, s2, isValid(s2))
    println()

    val s3 = "(]"
    println(3, s3, isValid(s3))
    println()

    val s4 = "([)]"
    println(4, s4, isValid(s4))
    println()

    val s5 = "{[]}"
    println(5, s5, isValid(s5))
    println()

    val s6 = ""
    println(6, s6, isValid(s6))
    println()

    val s7 = "(("
    println(7, s7, isValid(s7))
    println()
  }
}
