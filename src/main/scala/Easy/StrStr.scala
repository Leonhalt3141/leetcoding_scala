package Easy

object StrStr {
  /*
    EASY
    https://leetcode.com/problems/implement-strstr/
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    Input: haystack = "hello", needle = "ll"
    Output: 2

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
   */

  def strStr2(haystack: String, needle: String): Int = {
    if (needle.isEmpty) return 0
    val needle_length = needle.length
    val n = haystack.length

    for (i <- 0 until n) {
      val end_index = i + needle_length
      if (end_index > n) return -1
      else {
        val str = haystack.substring(i, end_index)
        if (str == needle) {
          return i
        }
      }
    }
    -1
  }

  def strStr(haystack: String, needle: String): Int = {
    if (needle.isEmpty) return 0
    val needle_length = needle.length

    for ((str, index) <- haystack.sliding(needle_length).zipWithIndex) {
      if (str matches needle) return index
    }
    -1
  }

  def main(args: Array[String]): Unit = {
    val haystack1 = "hello"
    val needle1 = "ll"
    println(strStr2(haystack1, needle1))

    val haystack2 = "aaaaa"
    val needle2 = "bba"
    println(strStr2(haystack2, needle2))
  }

}
