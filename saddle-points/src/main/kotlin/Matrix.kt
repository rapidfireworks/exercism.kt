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
        val maxOfRows = mutableListOf<Int>()
        for (row in matrix) {
          val value = row.maxOrNull()
          if (value != null) {
            maxOfRows.add(value)
          }
        }
        val minOfCols = mutableListOf<Int>()
        for (col in matrix[0].indices) {
          val values = mutableListOf<Int>()
          for (row in matrix.indices) {
            values.add(matrix[row][col])
          }
          val value = values.minOrNull()
          if (value != null) {
            minOfCols.add(value)
          }
        }
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
  }
}

data class MatrixCoordinate(val row: Int, val col: Int)
