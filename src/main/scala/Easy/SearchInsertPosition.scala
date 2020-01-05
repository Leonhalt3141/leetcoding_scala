package Easy

object SearchInsertPosition {
  /*
    EASY
    https://leetcode.com/problems/search-insert-position/
    Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
    Input: [1,3,5,6], 5
    Output: 2

    Input: [1,3,5,6], 2
    Output: 1

    Input: [1,3,5,6], 7
    Output: 4

    Input: [1,3,5,6], 0
    Output: 0


   */
  def searchInsert2(nums: Array[Int], target: Int): Int = {
    if (nums == null || nums.isEmpty) return 0
    go(nums, 0, nums.length - 1, target)
  }

  private def go(nums: Array[Int], start: Int, end: Int, target: Int): Int = {
    val mid = start + (end - start) / 2
    if (end < start || nums(mid) == target) mid
    else if (nums(mid) < target) go(nums, mid + 1, end, target)
    else go(nums, start, mid - 1, target)
  }

  def searchInsert(nums: Array[Int], target: Int): Int = {
    if (nums.isEmpty || target <= nums.head) return 0
    else if (target > nums.last) return nums.length

    var index = 0
    for (num_range <- nums.sliding(3).toArray) {
      if (target <= num_range.head) return index
      else if (num_range.head < target && target <= num_range(1)) return index + 1
      else if (target <= num_range.last) return index + 2
      else index += 1
    }
    index + 2
  }

  def main(args: Array[String]): Unit = {
    val nums1 = Array(1, 3, 5, 6)
    val target1 = 5
    println(searchInsert(nums1, target1))

    val nums2 = Array(1,3,5,6)
    val target2 = 2
    println(searchInsert(nums2, target2))

    val nums3 = Array(1,3,5,6)
    val target3 = 7
    println(searchInsert(nums3, target3))

    val nums4 = Array(1,3,5,6)
    val target4 = 0
    println(searchInsert(nums4, target4))

    val nums5 = Array(1, 3)
    val target5 = 4
    println(searchInsert(nums5, target5))
  }
}
