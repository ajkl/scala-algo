package sort

/**
 * Created by ajkale on 6/27/15.
 */
object Insertion {

  def sort[T](arr: List[T])(implicit ord: Ordering[T]): List[T] = {

    def less(x: T, y: T): Boolean = ord.lt(x, y)

    def insert(x: T, sorted: List[T]): List[T] = {

      def insertHelper(y: T, left: List[T], right: List[T]): List[T] = {
        if (left.isEmpty) y +: right
        else {
          if (less(y, left.last)) insertHelper(y, left.take(left.size - 1), left.last +: right)
          else (left :+ y) ++ right
        }
      }
      insertHelper(x, sorted, List())
    }

    def sortHelper(sorted: List[T], unsorted: List[T]): List[T] = {
      if (unsorted.isEmpty) sorted
      else {
        sortHelper(insert(unsorted.head, sorted), unsorted.tail)
      }
    }
    sortHelper(List(), arr)
  }

}
