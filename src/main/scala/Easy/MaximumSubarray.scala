package Easy

object MaximumSubarray {
  /*
    EASY
    https://leetcode.com/problems/maximum-subarray/
   */
  def maxSubArray(nums: Array[Int]): Int = {
//    nums.tail.scan(nums.head){(s, e) => math.max(s+e, e)}.max

    var max = nums.head
    var curr = nums.head

    for (i <- 1 until nums.length){
      curr = Math.max(curr + nums(i), nums(i))
      max = Math.max(max, curr)
    }
    max

//    import scala.collection.mutable.ArrayBuffer
//    val n = nums.length
//
//    if (n == 1) return nums.head
//
//    val results = new ArrayBuffer[Int]()
//
//    for (i <- 0 until n) {
//      for (j <- i + 1 until n + 1) {
//        results.append(nums.slice(i, j).sum)
//      }
//    }
//    results.max
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(-2, 1, -3 , 4, -1, 2, 1, -5, 4)
    println(maxSubArray(nums))

    val nums1 = Array(1)
    println(maxSubArray(nums1))

    val nums2 = Array(-2, 1)
    println(maxSubArray(nums2))

    val nums3 = Array(-2, -1)
    println(maxSubArray(nums3))
  }
}
