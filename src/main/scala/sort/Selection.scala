package sort

/**
 * Created by ajkale on 6/27/15.
 */
object Selection {
  def sort[T](arr: List[T])(implicit ord: Ordering[T]): List[T] = {

    def less(x: T, y: T): Boolean = ord.lt(x, y)

    def sortHelper(sorted: List[T], unsorted: List[T]): List[T] = {
      if (unsorted.isEmpty) sorted
      else {
        val min = unsorted.min
        if (less(unsorted.head, min)) sortHelper(sorted :+ unsorted.head, unsorted.tail)
        else sortHelper(sorted :+ min, unsorted diff List(min))
      }
    }

    sortHelper(List(), arr)
  }

}
