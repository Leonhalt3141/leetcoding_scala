package Easy

object LastWorldLength {
  def lengthOfLastWord(s: String): Int = {
    val split = s.split(" ")
    if (split.isEmpty) return 0
    split.last.length
  }

  def main(args: Array[String]): Unit = {

  }
}
