package Easy

object LongestCommonPrefix {

  def createPrefixs(word: String): List[String] = {
    val n = word.length
    if (n == 1) {
      List(word)
    } else {
      (1 until n).map { i =>
        word.slice(0, i)
      }.toList.distinct
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
      val index = prefixs.
        map(prefix => check(prefix, words.tail)).
        zipWithIndex.filter(_._1 == true).map(_._2)

      if (index.nonEmpty) {
        prefixs(index(index.map(i => prefixs(i).length).zipWithIndex.maxBy(_._1)._2))

      } else ""
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
