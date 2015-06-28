package unionfind

/**
 * Created by ajkale on 6/21/15.
 */
class QuickFindUF(n: Int) {

  private var id = (0 to n).toArray
  private var cnt = n

  def count: Int = cnt

  def connected(p: Int, q: Int): Boolean = {
    id(p) == id(q)
  }

  def union(p: Int, q: Int): List[Int] = {
    val pid = id(p)
    val qid = id(q)
    id = id.map(x => if (x == pid) qid else x)
    cnt = cnt - 1
    id.toList
  }

}
