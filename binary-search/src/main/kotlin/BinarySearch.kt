object BinarySearch {

  fun search(list: List<Int>, item: Int): Int {
    val result = search(list, item, 0, list.size - 1)
    if (result != null) {
      return result
    } else {
      throw NoSuchElementException()
    }
  }

  tailrec fun search(list: List<Int>, item: Int, startIndex: Int, endIndex: Int): Int? {
    val pivotIndex = (startIndex + endIndex) / 2
    return if (startIndex < endIndex) {
      if (item < list[pivotIndex]) {
        search(list, item, startIndex, pivotIndex)
      } else if (item == list[pivotIndex]) {
        pivotIndex
      } else {
        search(list, item, pivotIndex + 1, endIndex)
      }
    } else {
      if (pivotIndex < list.size && item == list[pivotIndex]) {
        pivotIndex
      } else {
        null
      }
    }
  }
}
