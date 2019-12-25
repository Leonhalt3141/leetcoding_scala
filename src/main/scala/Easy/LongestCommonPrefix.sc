
def check(prefix: String, words: Array[String]): Boolean = {
  for (word <- words) {
    if (! word.contains(prefix)) return false
  }
  true
}

val pref = "fl"


def createPrefixs(word: String): List[String] = {
  val n = word.length
  if (n == 1) {
    List(word)
  } else {
    (1 until n+1).map { i =>
      word.slice(0, i)
    }.toList.distinct.map(pref => (pref, pref.length)).sortBy(_._2).reverse.map(_._1)
  }
}


val ca = "ca"

val strs = Array("ca", "a")
val prefixs = createPrefixs(strs.head)
val index = prefixs.
  map(prefix => check(prefix, strs.tail)).
  zipWithIndex.filter(_._1 == true).map(_._2)

createPrefixs("aa")

//index(index.map(i => prefixs(i).length).zipWithIndex.maxBy(_._1)._2)
//
//prefixs(index(index.map(i => prefixs(i).length).zipWithIndex.maxBy(_._1)._2))

//prefixs(index.map(i => prefixs(i).length).
//  zipWithIndex.maxBy(_._1)._1 - 1)
