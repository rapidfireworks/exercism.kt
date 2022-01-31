data class Robot(var name: String) {
  constructor() : this(NameGenerator.uniqueName()!!)

  fun reset() {
    name = NameGenerator.uniqueName()!!
  }
}

object NameGenerator {
  val didCreate = mutableSetOf<String>()

  tailrec fun uniqueName(): String? = synchronized(this) {
    return if (didCreate.size < 676_000) {
      val result = name()
      if (didCreate.add(result)) {
        result
      } else {
        uniqueName()
      }
    } else {
      null
    }
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
