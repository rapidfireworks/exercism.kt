object Hamming {

  fun compute(leftStrand: String, rightStrand: String): Int {
    if (leftStrand.length == rightStrand.length) {
      var result = 0
      for ((lhs, rhs) in leftStrand zip rightStrand) {
        if (lhs != rhs) {
          result += 1
        }
      }
      return result
    } else {
      throw IllegalArgumentException("left and right strands must be of equal length")
    }
  }
}
