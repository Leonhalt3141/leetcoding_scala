package Easy


object RemoveDuplicates {

  def removeDuplicates2(nums: Array[Int]): Int = {
    def run(s: Int, e: Int): Int ={
      if (e > nums.length - 1) s
      else if (nums(s) == nums(e)) run(s, e + 1)
      else {
        nums(s + 1) = nums(e)
        run(s + 1, e + 1)
      }
    }
    if (nums.isEmpty) 0
    else 1 + run(0, 1)
  }

  def removeDuplicates(nums: Array[Int]): Int = {
    if (nums.isEmpty) 0
    else {
      var n = 1
      var j = 0
      val max = nums.last + 1

      for (i <- 1 until nums.length) {
        if (nums(i) == nums(j)) {
          nums(i) = max
        } else {
          j = i
          n += 1
        }

      }
      scala.util.Sorting.quickSort(nums)
      n
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    println(removeDuplicates2(nums))

    println()
    nums.foreach(println)
  }

}
