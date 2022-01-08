data class Matrix(val matrix: List<List<Int>>) {

  val saddlePoints: Set<MatrixCoordinate>

  init {
    this.saddlePoints = saddlePoints(matrix)
  }

  companion object {
    fun saddlePoints(matrix: List<List<Int>>): Set<MatrixCoordinate> {
      if (matrix.isEmpty()) {
        return setOf()
      } else {
        val maxOfRows = matrix.mapNotNull { it.maxOrNull() }
        val minOfCols = minOfCols(matrix)
        val result = mutableSetOf<MatrixCoordinate>()
        for (row in matrix.indices) {
          for (col in matrix[row].indices) {
            val value = matrix[row][col]
            if (value == maxOfRows[row] && value == minOfCols[col]) {
              result.add(MatrixCoordinate(row + 1, col + 1))
            }
          }
        }
        return result
      }
    }

    fun minOfCols(matrix: List<List<Int>>): List<Int> {
      val result = mutableListOf<Int>()
      for (col in matrix[0].indices) {
        val values = mutableListOf<Int>()
        for (row in matrix.indices) {
          values.add(matrix[row][col])
        }
        val value = values.minOrNull()
        if (value != null) {
          result.add(value)
        }
      }
      return result
    }
  }
}

data class MatrixCoordinate(val row: Int, val col: Int)
