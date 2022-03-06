import kotlin.math.*

data class ComplexNumber(val real: Double = 0.0, val imag: Double = 0.0) {

  val abs
    get() = sqrt(real.pow(2) + imag.pow(2))

  operator fun times(o: ComplexNumber): ComplexNumber {
    return ComplexNumber(real * o.real - imag * o.imag, real * o.imag + imag * o.real)
  }

  operator fun plus(o: ComplexNumber): ComplexNumber {
    return ComplexNumber(real + o.real, imag + o.imag)
  }

  operator fun minus(o: ComplexNumber): ComplexNumber {
    return ComplexNumber(real - o.real, imag - o.imag)
  }

  operator fun div(o: ComplexNumber): ComplexNumber {
    val denominator = o.real.pow(2) + o.imag.pow(2)
    return this * ComplexNumber(o.real / denominator, -o.imag / denominator)
  }

  fun conjugate(): ComplexNumber {
    return ComplexNumber(real, -imag)
  }
}

fun exponential(number: ComplexNumber): ComplexNumber {
  val multiplier = E.pow(number.real)
  return ComplexNumber(multiplier * cos(number.imag), multiplier * sin(number.imag))
}
