data class Matrix(val matrix: List<List<Int>>) {

  constructor(matrix: String) : this(parse(matrix, """\p{Z}*\n\p{Z}*""", """\p{Z}+"""))

  companion object {
    fun parse(matrix: String, lnRegex: String, spRegex: String): List<List<Int>> {
      return parse(matrix, Regex(lnRegex), Regex(spRegex))
    }

    fun parse(matrix: String, lnRegex: Regex, spRegex: Regex): List<List<Int>> {
      return matrix.split(lnRegex).map { parse(it, spRegex) }
    }

    fun parse(line: String, spRegex: Regex): List<Int> {
      return line.split(spRegex).mapNotNull(String::toIntOrNull)
    }
  }

  fun column(colNr: Int): List<Int> {
    return matrix.map { it[colNr - 1] }
  }

  fun row(rowNr: Int): List<Int> {
    return matrix[rowNr - 1]
  }
}
