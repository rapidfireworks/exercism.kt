data class Matrix(val matrix: List<List<Int>>) {

  constructor(
      matrix: String
  ) : this(parse(matrix, Regex("""\p{Z}*\n\p{Z}*"""), Regex("""\p{Z}+""")))

  companion object {
    fun parse(matrix: String, lnRegex: Regex, spRegex: Regex): List<List<Int>> {
      var result = mutableListOf<List<Int>>()
      for (line in matrix.split(lnRegex)) {
        var elements = mutableListOf<Int>()
        for (letter in line.split(spRegex)) {
          val element = letter.toIntOrNull()
          if (element != null) {
            elements.add(element)
          }
        }
        result.add(elements)
      }
      return result
    }
  }

  fun column(colNr: Int): List<Int> {
    var result = mutableListOf<Int>()
    for (line in matrix) {
      result.add(line[colNr - 1])
    }
    return result
  }

  fun row(rowNr: Int): List<Int> {
    return matrix[rowNr - 1]
  }
}
