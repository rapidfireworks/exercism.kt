object Hamming {

  fun compute(leftStrand: String, rightStrand: String): Int {
    if (leftStrand.length == rightStrand.length) {
      return leftStrand.zip(rightStrand).count { (lhs, rhs) -> lhs != rhs }
    } else {
      throw IllegalArgumentException("left and right strands must be of equal length")
    }
  }
}
