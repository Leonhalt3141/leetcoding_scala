package Easy

object LongestCommonPrefix {

  def createPrefixs(word: String): List[String] = {
    val n = word.length
    if (n == 1) {
      List(word)
    } else {
      (1 until n+1).map { i =>
        word.slice(0, i)
      }.toList.distinct.map(pref => (pref, pref.length)).sortBy(_._2).reverse.map(_._1)
    }
  }

  def check(prefix: String, words: Array[String]): Boolean = {
    for (word <- words) {
      if (prefix != word.slice(0, prefix.length)) return false
    }
    true
  }


  def longestCommonPrefix(strs: Array[String]): String = {
    if (strs.isEmpty) {
      ""
    } else if (strs.length == 1) {
      strs.head
    } else {
      val words = strs.map(str => (str, str.length)).sortBy(_._2).map(_._1)
      val prefixs = createPrefixs(words.head)

      for (prefix <- prefixs) {
        if (check(prefix, words.tail)) {
          return prefix
        }
      }
      ""
    }
  }

  def main(args: Array[String]): Unit = {
    val words1 = Array("flower","flow","flight")
    println(1, longestCommonPrefix(words1))

    val words2 = Array("dog","racecar","car")
    println(2, longestCommonPrefix(words2))

    val words3 = Array("c", "c")
    println(3, longestCommonPrefix(words3))

    val words4 = Array("aa", "aa")
    println(4, longestCommonPrefix(words4))

    val words5 = Array("ca", "a")
    println(5, longestCommonPrefix(words5))
  }
}
