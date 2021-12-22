data class Matrix(val matrix: List<List<Int>>) {

  constructor(matrix: String) : this(parseMatrix(matrix, """\R""", """\p{Zs}+"""))

  companion object {
    fun parseMatrix(matrix: String, lnRegex: String, spRegex: String): List<List<Int>> {
      return parseMatrix(matrix, Regex(lnRegex), Regex(spRegex))
    }

    fun parseMatrix(matrix: String, lnRegex: Regex, spRegex: Regex): List<List<Int>> {
      return matrix.split(lnRegex).map { parseLine(it, spRegex) }
    }

    fun parseLine(line: String, spRegex: Regex): List<Int> {
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
