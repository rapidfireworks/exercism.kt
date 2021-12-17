import java.text.BreakIterator

object Hamming {

  fun compute(leftStrand: String, rightStrand: String): Int {
    var result = 0
    val rightGraphemes = Graphemes(rightStrand)
    for (lhs in Graphemes(leftStrand)) {
      if (!rightGraphemes.hasNext()) {
        throw DifferentLengthException()
      } else if (lhs != rightGraphemes.next()) {
        result += 1
      }
    }
    if (rightGraphemes.hasNext()) {
      throw DifferentLengthException()
    } else {
      return result
    }
  }

  class DifferentLengthException :
      IllegalArgumentException("left and right strands must be of equal length") {}
}

class Graphemes : Iterator<String> {

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

  override operator fun hasNext(): Boolean {
    return endIndex != BreakIterator.DONE
  }

  override operator fun next(): String {
    val result = text.substring(startIndex, endIndex)
    startIndex = endIndex
    endIndex = iterator.next()
    return result
  }
}
