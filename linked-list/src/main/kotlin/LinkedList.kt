data class Deque<T>(var header: Node<T>? = null, var trailer: Node<T>? = null) {

  fun push(value: T) {
    val node = Node(value)
    if (header == null) {
      trailer = node
    } else {
      node.appendNext(header)
    }
    header = node
  }

  fun pop(): T? {
    val result = header?.value
    if (header == trailer) {
      header = null
      trailer = null
    } else {
      header = header?.next
      header?.prev?.removeNext()
    }
    return result
  }

  fun unshift(value: T) {
    val node = Node(value)
    if (trailer == null) {
      header = node
    } else {
      trailer?.appendNext(node)
    }
    trailer = node
  }

  fun shift(): T? {
    val result = trailer?.value
    if (header == trailer) {
      header = null
      trailer = null
    } else {
      trailer = trailer?.prev
      trailer?.removeNext()
    }
    return result
  }
}

data class Node<T>(val value: T, var prev: Node<T>? = null, var next: Node<T>? = null) {

  fun appendNext(node: Node<T>?) {
    next = node
    node?.prev = this
  }

  fun removeNext() {
    next?.prev = null
    next = null
  }
}
