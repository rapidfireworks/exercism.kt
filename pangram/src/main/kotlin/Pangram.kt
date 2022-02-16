object Pangram {

  val alphabetCount = ('a'..'z').count()

  fun isPangram(input: String): Boolean = lowercaseLetters(input).size == alphabetCount

  fun lowercaseLetters(input: String): Set<String> = mutableSetOf<String>().apply {
    for (rune in input) {
      if (rune.isLetter()) {
        add(rune.lowercase())
      }
    }
  }
}
