import adt.{Stack, Queue}
import sort.{Insertion, Selection}

val l = Array.range(0, 9).toList
1 :: l
val st = new Stack[String]
st.push("ajinkya")
st.print
st.push("kale")
st.print
val s = st.pop().getOrElse("")
st.print
val ll = List(1,2) :+ 3
ll.head
val q = new Queue[Double]
q.enqueue(1)
q.enqueue(2)
q.print
q.dequeue
q.enqueue(3)
q.print
q.dequeue
q.print
val arr = 0 to 10
arr.takeRight(arr.size-1)

def sortHelper[T](sorted: List[T], unsorted: List[T])(implicit ord: Ordering[T]): List[T] = {

  def less(x: T, y: T) = ord.lt(x, y)

  if (unsorted.isEmpty) sorted
  else {
    val min = unsorted.min
    if (less(unsorted.head, min)) sortHelper(sorted :+ unsorted.head, unsorted.tail)
    else sortHelper(sorted :+ min, unsorted diff List(min))
  }
}

sortHelper(List(), List(4,6,3,5,2,5,1,6))
Selection.sort(List(4,6,3,5,2,5,1,6))

val l1 = List(1,2,3,4)
l1.take(l1.size-1)

Insertion.sort(List(4,6,3,5,0,10,2,5,1,6))


















