package adt

/**
 * Created by ajkale on 6/22/15.
 */
class Stack[T] {

  private var stackList: List[T] = List()

  def pop[T]() = {
    stackList match {
      case head :: tail => {
        stackList = tail
        Some(head)
      }
      case _ => None
    }
  }

  def push(elem: T) = {
    stackList = elem :: stackList
  }

  def isEmpty = stackList.isEmpty

  def size = stackList.size

  def print = println(stackList)

}
