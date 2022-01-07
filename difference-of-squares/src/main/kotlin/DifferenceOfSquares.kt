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
    return pow(base, exp, 1)
  }

  tailrec fun pow(base: Int, exp: Int, multiplier: Int): Int {
    if (0 < exp) {
      return when (exp % 2) {
        0 -> pow(base * base, exp / 2, multiplier)
        else -> pow(base, exp - 1, multiplier * base)
      }
    } else {
      return when (exp) {
        0 -> multiplier
        else -> 0
      }
    }
  }
}
