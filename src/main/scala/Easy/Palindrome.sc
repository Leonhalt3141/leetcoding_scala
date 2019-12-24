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

println(reverseInteger(122))
println(reverseInteger(-122))