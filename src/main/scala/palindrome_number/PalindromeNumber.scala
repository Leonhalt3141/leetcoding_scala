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
        val temp = reversed * 10 + target % 10
        if (temp / 10 != reversed){
          return 0
        }
        reversed = temp
        target /= 10
      }
      reversed
    }

    if (x < 0) {
      false
    } else {
      val x_ = reverseInteger(x)
      if (x - x_ == 0) true else false
    }
  }

  def main(args: Array[String]): Unit = {
    val number = -121

    println(isPalindrome(number))

    println(isPalindrome2(12521))
  }

}
