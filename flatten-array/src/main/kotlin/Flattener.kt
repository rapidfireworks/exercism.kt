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

  fun <T : Any> nestedList(source: Collection<Any?>, type: KClass<T>): ColNestedList<T> {
    val result = mutableListOf<NestedList<T>>()
    for (element in source) {
      if (type.isInstance(element)) {
        result.add(ValNestedList(type.cast(element)))
      } else {
        when (element) {
          null -> continue
          is Collection<Any?> -> result.add(nestedList(element, type))
          else -> throw IllegalArgumentException()
        }
      }
    }
    return ColNestedList(result)
  }
}

sealed class NestedList<T>

data class ValNestedList<T>(val value: T) : NestedList<T>()

data class ColNestedList<T>(val list: List<NestedList<T>>) : NestedList<T>()
