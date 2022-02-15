object Pangram {

  val alphabetCount = ('a'..'z').count()

  fun isPangram(input: String): Boolean {
    val set = mutableSetOf<String>()
    for (rune in input) {
      if (rune.isLetter()) {
        set.add(rune.lowercase())
      }
    }
    return set.size == alphabetCount
  }
}
