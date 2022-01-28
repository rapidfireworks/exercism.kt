data class RotationalCipher(val key: Int) {

  val letters = (('A'..'Z') + ('a'..'z')).toSet()

  fun encode(text: String): String = text.map(::encode).joinToString("")

  fun encode(letter: Char): Char = when (val base = base(letter)) {
    null -> letter
    else -> ((letter.code - base + key) % 26 + base).toChar()
  }

  fun base(letter: Char): Int? = if (!letters.contains(letter)) {
    null
  } else if (letter.isUpperCase()) {
    'A'.code
  } else {
    'a'.code
  }
}
