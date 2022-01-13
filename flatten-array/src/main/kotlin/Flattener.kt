object Flattener {

  fun flatten(source: Collection<Any?>): List<Any> {
    return mutableListOf<Any>().also { flatten(source, it) }
  }

  fun flatten(source: Collection<Any?>, result: MutableList<Any>) {
    for (element in source) {
      when (element) {
        null -> continue
        is Collection<Any?> -> flatten(element, result)
        else -> result.add(element)
      }
    }
  }
}
