object Raindrops {

  fun convert(n: Int): String {
    val result = buildString {
      for (factor in listOf(3, 5, 7)) {
        sound(n, factor)?.let(::append)
      }
    }
    return result.ifEmpty {
      n.toString()
    }
  }

  fun sound(n: Int, factor: Int): String? = if (n % factor == 0) {
    when (factor) {
      3 -> "Pling"
      5 -> "Plang"
      7 -> "Plong"
      else -> null
    }
  } else {
    null
  }
}
