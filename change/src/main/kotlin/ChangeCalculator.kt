data class ChangeCalculator(val coins: List<Int>) {

  fun computeMostEfficientChange(grandTotal: Int): List<Int> {
    if (grandTotal < 0) {
      throw IllegalArgumentException("Negative totals are not allowed.")
    } else {
      val result = MutableBox<List<Int>?>(null)
      computeMostEfficientChange(grandTotal, coins.size - 1, mutableListOf(), result)
      result.value?.run {
        return this
      }
      throw IllegalArgumentException("The total $grandTotal cannot be represented in the given currency.")
    }
  }

  fun computeMostEfficientChange(
    grandTotal: Int,
    endIndex: Int,
    values: MutableList<Int>,
    result: MutableBox<List<Int>?>
  ) {
    if (result.value.let { it != null && it.size <= values.size }) {
      return
    } else if (0 < grandTotal) {
      for (index in endIndex downTo 0) {
        val coin = coins[index]
        values.add(coin)
        computeMostEfficientChange(grandTotal - coin, index, values, result)
        values.removeLastOrNull()
      }
    } else if (grandTotal == 0) {
      result.value = values.toList()
    }
  }
}

data class MutableBox<T>(var value: T)
