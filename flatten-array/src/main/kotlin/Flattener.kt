import kotlin.reflect.KClass
import kotlin.reflect.cast

object Flattener {

  fun flatten(source: Collection<Any?>): List<Any> {
    val result = mutableListOf<Int>()
    flatten(nestedList(source, Int::class), result)
    return result
  }

  fun flatten(source: NestedList<Int>, result: MutableList<Int>) {
    when (source) {
      is ValNestedList -> result.add(source.value)
      is ColNestedList -> {
        for (element in source.list) {
          flatten(element, result)
        }
      }
    }
  }

  fun <T : Any> nestedList(source: Any?, type: KClass<T>): NestedList<T> {
    return when (source) {
      null -> ColNestedList(listOf())
      is Collection<Any?> -> ColNestedList(source.map { nestedList(it, type) })
      else -> {
        if (type.isInstance(source)) {
          ValNestedList(type.cast(source))
        } else {
          throw IllegalArgumentException()
        }
      }
    }
  }
}

sealed class NestedList<T>

data class ValNestedList<T>(val value: T) : NestedList<T>()

data class ColNestedList<T>(val list: List<NestedList<T>>) : NestedList<T>()
