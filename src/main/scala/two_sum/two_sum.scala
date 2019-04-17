package two_sum

object two_sum {
  /*
    https://leetcode.com/problems/two-sum/
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
    val nums = Array(3, 3)
    val target = 6

    val result = twosum2(nums, target)
    println(result.mkString(", "))

  }

}
