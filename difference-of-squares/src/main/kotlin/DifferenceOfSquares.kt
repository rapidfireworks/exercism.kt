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
    if (exp < 0) {
      return 0
    } else {
      var result = 1
      for (_index in 1..exp) {
        result *= base
      }
      return result
    }
  }
}
