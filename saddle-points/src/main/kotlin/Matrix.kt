data class Matrix(val matrix: List<List<Int>>) {

  val saddlePoints: Set<MatrixCoordinate>

  init {
    this.saddlePoints = saddlePoints(matrix)
  }

  companion object {
    fun saddlePoints(matrix: List<List<Int>>): Set<MatrixCoordinate> {
      val maxOfRows = matrix.mapNotNull { it.maxOrNull() }
      val minOfCols = minOfCols(matrix)
      val result = mutableSetOf<MatrixCoordinate>()
      for (row in matrix.indices) {
        for (col in matrix[row].indices) {
          val value = matrix[row][col]
          if (maxOfRows[row] <= value && value <= minOfCols[col]) {
            result.add(MatrixCoordinate(row + 1, col + 1))
          }
        }
      }
      return result
    }

    fun minOfCols(matrix: List<List<Int>>): List<Int> {
      if (matrix.isEmpty()) {
        return listOf()
      } else {
        val result = mutableListOf<Int>()
        for ((index, value) in matrix[0].withIndex()) {
          var minValue = value
          for (row in matrix.drop(1)) {
            val newValue = row[index]
            if (newValue < minValue) {
              minValue = newValue
            }
          }
          result.add(minValue)
        }
        return result
      }
    }
  }
}

data class MatrixCoordinate(val row: Int, val col: Int)
