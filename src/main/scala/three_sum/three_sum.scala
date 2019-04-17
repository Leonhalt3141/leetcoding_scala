/*
  https://leetcode.com/problems/3sum/
 */

package three_sum

object three_sum {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    if (nums.length < 3) throw new Exception("given nums have elements less than 3")

    val withIndex = nums.zipWithIndex
    val hashmap = withIndex.toMap


  }

  def main(args: Array[String]): Unit = {
    val nums = Array(-1, 0, 1, 2, -1, -4)

    val result = threeSum(nums)
  }
}
