object Isogram {

  fun isIsogram(input: String): Boolean {
    val letters = mutableSetOf<Char>()
    for (letter in input.lowercase()) {
      if (letter.isLowerCase()) {
        if (letters.contains(letter)) {
          return false
        } else {
          letters.add(letter)
        }
      }
    }
    return true
  }
}
