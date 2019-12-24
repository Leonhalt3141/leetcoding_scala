package Easy

object RomanToInteger {
  /*
    EASY
    https://leetcode.com/problems/roman-to-integer/
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.


   */

  def romanCharToInteger(char: Char): Int = char match{
      case 'M' => 1000
      case 'D' => 500
      case 'C' => 100
      case 'L' => 50
      case 'X' => 10
      case 'V' => 5
      case 'I' => 1
  }

  def conversion2(chars: List[Char]): Int = chars match {
    case left :: right :: tails =>
      val v1 = romanCharToInteger(left)
      val v2 = romanCharToInteger(right)

      if (v1 < v2) {
        v2 - v1 + conversion2(tails)
      } else {
        v1 + conversion2(chars.tail)
      }
    case left :: Nil => romanCharToInteger(left)
    case Nil => 0
  }

  def conversion(chars: List[Char]): Int = {

    if (chars.isEmpty){
      0
    } else if (chars.length < 2) {
      romanCharToInteger(chars.head)

    } else {
      val left = romanCharToInteger(chars.head)
      val right = romanCharToInteger(chars(1))

      if (left < right) {
        right - left + conversion(chars.tail.tail)
      } else {
        left + conversion(chars.tail)
      }
    }
  }

  def romanToInt(s: String): Int = {
    val romans = s.toList
    conversion2(romans)
  }


  def main(args: Array[String]): Unit = {
    val roman = "MCMXCIV"

    println(romanToInt(roman))
  }

}
