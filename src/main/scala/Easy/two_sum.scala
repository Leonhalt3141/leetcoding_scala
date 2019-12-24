package Easy

object two_sum {
  /*
    EASY
    https://leetcode.com/problems/two-sum/
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
  */

  def twosum(nums: Array[Int], target: Int): Array[Int] = {
    for (i <- nums.indices) {
      val answer = target - nums(i)
      for (j <- i + 1 until nums.length) {
        if ( answer == nums(j)) {
          return Array(i, j)
        }
      }
    }
    throw new Exception("index not found")
  }

  def twosum2(nums: Array[Int], target: Int): Array[Int] = {
    val withIndex = nums.zipWithIndex
    val hashmap = withIndex.toMap
    withIndex.collectFirst {
      case (value, index) if hashmap.get(target - value).exists(_ != index) => Array(index, hashmap(target-value))
    }.get
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(2, 7, 11, 15)
    val target = 9

    val result = twosum2(nums, target)
    println(result.mkString(", "))

  }

}
