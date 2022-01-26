data class Robot(var name: String) {

  constructor() : this(uniqueName()!!)

  fun reset() {
    name = uniqueName()!!
  }

  companion object {
    val created = mutableSetOf<String>()

    fun uniqueName(): String? {
      val limit = 26 * 26 * 1000
      while (created.size <= limit) {
        val result = name()
        if (!created.contains(result)) {
          created.add(result)
          return result
        }
      }
      return null
    }

    fun name(): String {
      val builder = StringBuilder()
      for (_count in 0 until 2) {
        builder.append(('A'..'Z').random())
      }
      builder.append("%03d".format((0 until 1000).random()))
      return builder.toString()
    }
  }
}
