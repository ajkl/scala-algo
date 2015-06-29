package sort

import scala.collection.mutable
/**
 * Created by ajkale on 6/28/15.
 */
object Merge {

  def sort[T](arr: List[T])(implicit ord: Ordering[T]): List[T] = {

    def less(x: T, y: T): Boolean = ord.lt(x, y)

    def merge(left: List[T], right: List[T]): List[T] = {
      var i = 0
      var j = 0
      var l: mutable.MutableList[T] = mutable.MutableList()
      while (i < left.size && j < right.size) {
        if (less(left(i), right(j))) {
          l = l :+ left(i)
          i = i + 1
        } else {
          l = l :+ right(j)
          j = j + 1
        }
      }
      if (i != left.size) l = l ++ left.takeRight(left.size - i)
      if (j != right.size) l = l ++ right.takeRight(right.size - j)
      l.toList
    }

    def mergeSort(arr: List[T]): List[T] = {
      val mid = arr.size / 2
      if (mid == 0) arr
      else {
        val (left, right) = arr.splitAt(mid)
        merge(mergeSort(left), mergeSort(right))
      }
    }

    mergeSort(arr)
  }

}

/*  A more functional way to do mergesort
class MergeSort(arr: List[Int]) {

  def merge(l: List[Int], r: List[Int]): List[Int] =
    (l, r) match {
      case (Nil, r) => r
      case (l, Nil) => l
      case (hl :: tl, hr :: tr) =>
        if (hl < hr) hl :: merge(tl, r)
        else hr :: merge(l, tr)
    }

  def mergeSort(arr: List[Int]): List[Int] = {
    val mid = arr.length / 2
    if (mid == 0) arr
    else {
      val (left, right) = arr.splitAt(mid)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  def sort() = mergeSort(arr)
}
*/