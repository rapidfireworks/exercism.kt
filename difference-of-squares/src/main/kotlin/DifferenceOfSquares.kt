data class Squares(val n: Int) {

  fun sumOfSquares(): Int {
    return n * (n + 1) * (2 * n + 1) / 6
  }

  fun squareOfSum(): Int {
    return pow(n * (n + 1) / 2, 2)
  }

  fun difference(): Int {
    return squareOfSum() - sumOfSquares()
  }

  fun pow(base: Int, exp: Int): Int {
    return when {
      0 < exp -> {
        var result = base
        var exponent = 1
        val halfExp = exp / 2
        while (exponent < exp) {
          if (halfExp < exponent) {
            result *= base
            exponent += 1
          } else {
            result *= result
            exponent *= 2
          }
        }
        result
      }
      exp == 0 -> 1
      else -> 0
    }
  }
}
