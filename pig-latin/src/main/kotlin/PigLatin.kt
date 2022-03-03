object PigLatin {

  fun translate(phrase: String): String {
    return translate(
      phrase,
      listOf(
        Regex("""(^)((?:[aeiou]|xr|yt)\p{L}*$)"""),
        Regex("""(^[\p{L}&&[^aeiou]]?qu)(\p{L}*$)"""),
        Regex("""(^[\p{L}&&[^aeiou]]+)(y\p{L}*$)"""),
        Regex("""(^[\p{L}&&[^aeiou]]+)(\p{L}*$)""")
      )
    )
  }

  fun translate(phrase: String, expressions: List<Regex>): String {
    return phrase.split(Regex("""\p{Z}+""")).joinToString(" ") {
      translateWord(it, expressions)
    }
  }

  fun translateWord(word: String, expressions: List<Regex>): String {
    for (regex in expressions) {
      val result = regex.matchEntire(word)
      if (result != null && 2 < result.groupValues.size) {
        return buildString {
          append(result.groupValues[2])
          append(result.groupValues[1])
          append("ay")
        }
      }
    }
    return buildString {
      append(word)
      append("ay")
    }
  }
}
