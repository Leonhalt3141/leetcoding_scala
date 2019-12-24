package palindrome_number

object PalindromeNumber {
  /*
    EASY
    https://leetcode.com/problems/palindrome-number/
    Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
   */

  def isPalindrome(x: Int): Boolean = {
    val strX = x.toString
    if (strX matches(strX.reverse.toString)) true else false
  }

  def isPalindrome2(x: Int): Boolean = {
    def reverseInteger(num: Int): Int = {
      var reversed = 0
      var target = num
      while (target != 0) {
        reversed = reversed * 10 + target % 10
        target /= 10
      }
      reversed
    }

    if (x < 0 || (x % 10 == 0 && x != 0)) {
      false
    } else {
      val x_ = reverseInteger(x)
      x - x_ == 0
    }
  }

  def main(args: Array[String]): Unit = {
    val number = -121

    println(isPalindrome(number))

    println(isPalindrome2(12521))
  }

}
