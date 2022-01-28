import java.util.concurrent.ConcurrentHashMap

data class Robot(var name: String) {

  constructor() : this(uniqueName()!!)

  fun reset() {
    name = uniqueName()!!
  }

  companion object {
    val didCreate = ConcurrentHashMap<String, Boolean>()

    fun uniqueName(): String? {
      val limit = 26 * 26 * 1000
      while (didCreate.size <= limit) {
        val result = name()
        when (didCreate.put(result, true)) {
          null -> return result
          else -> continue
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
