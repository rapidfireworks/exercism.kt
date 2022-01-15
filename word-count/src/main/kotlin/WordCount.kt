object WordCount {

  fun phrase(phrase: String): Map<String, Int> {
    return phrase(phrase, Regex("""\b[\p{L}\p{N}']+\b"""))
  }

  fun phrase(phrase: String, regex: Regex): Map<String, Int> {
    return mutableMapOf<String, Int>().apply {
      for (result in regex.findAll(phrase)) {
        result.value.lowercase().let { put(it, getOrDefault(it, 0) + 1) }
      }
    }
  }
}
