object HandshakeCalculator {

  fun calculateHandshake(number: Int): List<Signal> {
    val result = mutableListOf<Signal>()
    for (operation in operations(number)) {
      val signal = signal(number and operation)
      if (signal != null) {
        result.add(signal)
      }
    }
    return result
  }

  fun operations(number: Int): IntArray {
    return when (number and 16) {
      0 -> intArrayOf(1, 2, 4, 8)
      else -> intArrayOf(8, 4, 2, 1)
    }
  }

  fun signal(operation: Int): Signal? {
    return when (operation) {
      1 -> Signal.WINK
      2 -> Signal.DOUBLE_BLINK
      4 -> Signal.CLOSE_YOUR_EYES
      8 -> Signal.JUMP
      else -> null
    }
  }
}
