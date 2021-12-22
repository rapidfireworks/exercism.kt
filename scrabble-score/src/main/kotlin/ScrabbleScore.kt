import java.text.BreakIterator

object ScrabbleScore {

  fun scoreLetter(c: Char): Int {
    return scoreGrapheme(c.toString())
  }

  fun scoreWord(word: String): Int {
    return Graphemes(word.uppercase()).sumOf(::scoreGrapheme)
  }

  fun scoreGrapheme(grapheme: String): Int {
    return when (grapheme) {
      "A", "E", "I", "O", "U", "L", "N", "R", "S", "T" -> 1
      "D", "G" -> 2
      "B", "C", "M", "P" -> 3
      "F", "H", "V", "W", "Y" -> 4
      "K" -> 5
      "J", "X" -> 8
      "Q", "Z" -> 10
      else -> 0
    }
  }

  class Graphemes : Iterator<String>, Iterable<String> {
    val text: String
    val iterator: BreakIterator
    var startIndex: Int
    var endIndex: Int

    constructor(text: String) {
      this.text = text
      this.iterator = BreakIterator.getCharacterInstance().apply { setText(text) }
      this.startIndex = this.iterator.first()
      this.endIndex = this.iterator.next()
    }

    override fun hasNext(): Boolean {
      return endIndex != BreakIterator.DONE
    }

    override fun next(): String {
      val result = text.substring(startIndex, endIndex)
      startIndex = endIndex
      endIndex = iterator.next()
      return result
    }

    override fun iterator(): Iterator<String> {
      return this
    }
  }
}
