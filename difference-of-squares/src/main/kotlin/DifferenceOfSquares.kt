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
    if (exp < 0) {
      return 0
    } else if (exp < 1) {
      return multiplier
    } else if (0 < exp % 2) {
      return pow(base, exp - 1, multiplier * base)
    } else {
      return pow(base * base, exp / 2, multiplier)
    }
  }
}
