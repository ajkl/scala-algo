package unionfind

/**
 * Created by ajkale on 6/22/15.
 */
class QuickUnionUF(n: Int) {

  private var id = Array.range(0, n)
  private var cnt = n

  def count: Int = cnt

  def root(i: Int): Int = {
    if(id(i) == i) i
    else root(id(i))
  }

  def connected(p: Int, q: Int): Boolean = {
    root(p) == root(q)
  }

  def union(p: Int, q: Int): List[Int] = {
    val proot = root(p)
    val qroot = root(q)
    id(proot) = qroot
    cnt = cnt - 1
    id.toList
  }

}
