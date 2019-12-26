package Easy

object RemoveElement {
  def removeElement(nums: Array[Int], value: Int): Int = {
    nums.foldLeft(0)((index, vv) => {
      if (vv == value) index
      else {
        nums(index) = vv
        index + 1
      }
    })
    }

  def removeElement2(nums: Array[Int], value: Int): Int = {
    def run(i: Int, j: Int, c: Int): Int = {
      if (j > nums.length - 1) c
      else if (nums(j) == value) run(i, j+1, c)
      else {
        nums(i) = nums(j)
        run(i+1, j+1, c+1)
      }
    }
    run(0, 0, 0)
  }

//    def run(i: Int, j: Int): Int = {
//      if (nums(i) != value && j == nums.length) 1
//      else if (j > nums.length - 1) i
//      else if (nums(i) == value && nums(j) != value) {
//        nums(i) = nums(j)
//        nums(j) = value
//        run(i + 1, j + 1)
//      } else if (nums(i) == value && nums(j) == value) {
////        nums(j) = nums(j + 1)
//        run(i, j + 1)
//      } else if  (nums(i) != value && nums(j) == value) {
////        nums(j) = nums(j + 1)
//        run(i + 1, j + 1)
//      } else if (nums(i) != value && nums(j) != value) {
////        nums(j) = value
//        run(i + 2, j + 2)
//      } else {
//        run(i + 1, j + 1)
//      }
//    }

//    if (nums.isEmpty) 0
//    else run(0, 1, 1)
//  }

  def main(args: Array[String]): Unit = {
    val nums = Array(0, 1, 2, 2, 3, 0, 4, 2)

    val result = removeElement2(nums, 2)
    println(result)

    println()

    nums.slice(0, result).foreach(println)
    println("==============")

    val nums2 = Array(3, 2, 2, 3)
    val result2 = removeElement2(nums2, 3)
    println(result2)
    println()

    nums2.slice(0, result2).foreach(println)
    println("==============")

    val nums3 = Array(2)

    val result3 = removeElement2(nums3, 3)
    println(result3)

    println()

    nums3.slice(0, result3).foreach(println)
    println("==============")

    val nums4 = Array(3, 3)

    val result4 = removeElement2(nums3, 5)
    println(result4)

    println()

    nums4.slice(0, result4).foreach(println)


  }

}
