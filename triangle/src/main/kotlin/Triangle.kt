data class Triangle<out T : Number>(val a: T, val b: T, val c: T) {

  init {
    require(isValid(a.toDouble(), b.toDouble(), c.toDouble()))
  }

  companion object {
    fun isValid(a: Double, b: Double, c: Double): Boolean {
      val sides = doubleArrayOf(a, b, c)
      sides.sort()
      return 0 < sides[0] && sides[2] < sides[0] + sides[1]
    }
  }

  val isEquilateral: Boolean
    get() = a == b && b == c
  val isIsosceles: Boolean
    get() = a == b || b == c || c == a
  val isScalene: Boolean
    get() = !isIsosceles
}
