package sort

import scala.reflect.ClassTag

/**
 * Created by ajkale on 6/27/15.
 */
object Shell {

  def sort[T: Manifest](arr: List[T])(implicit ord: Ordering[T]): List[T] = {

    var arrMutable = new Array[T](arr.size)
    arr.copyToArray(arrMutable)

    def knuthStream(n: Int): Stream[Int] = n #:: knuthStream(3 * n + 1) // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...

    val hList = knuthStream(1).takeWhile(_ < arrMutable.size).toList
    for (i <- hList.reverse) {
      var j = 0
      do  {
        val indexes = (j to arrMutable.size - 1).filter(x => (x - j) % i == 0) //get the h-indexes to sort
        val hSorted = Insertion.sort(indexes.map(arrMutable(_)).toList) //sort the h-indexed elements using InsertSort

        for (k <- indexes.zipWithIndex) arrMutable(k._1) = hSorted(k._2) //push the hSorted elements back to the h-index positions

        j = j + 1
      } while (j + 2*i <= arrMutable.size) //atleast 2 elements condition
    }
    arrMutable.toList
    //Insertion.sort(arrMutable.toList)
  }

}
