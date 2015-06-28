package adt

/**
 * Created by ajkale on 6/26/15.
 */
class Queue[T] {

  var queueList: List[T] = List()

  def isEmpty = queueList

  def size = queueList.size

  def enqueue(elem: T) = {
    queueList = queueList :+ elem
  }

  def dequeue: T = {
    val head = queueList.head
    queueList = queueList.tail
    head
  }

  def print = println(queueList.toString())

}
