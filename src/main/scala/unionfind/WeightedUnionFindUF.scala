package unionfind

/**
 * Created by ajkale on 6/22/15.
 */
class WeightedUnionFindUF(n: Int) {

  private var id = Array.range(0, n)
  private var cnt = n
  private var size = Array.fill(n)(1)

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

    if (proot != qroot) {
      if (size(proot) < size(qroot)) {
        id(proot) = qroot
        size(qroot) += size(proot)
      }
      else {
        id(qroot) = proot
        size(proot) += size(qroot)
      }
      cnt = cnt - 1
    }

    id.toList
  }

}
