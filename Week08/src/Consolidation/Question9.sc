trait IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def isEmpty: Boolean
  def excl(x: Int): IntSet
  def union(x: IntSet): IntSet
  def intersection(x: IntSet): IntSet
}
case class EmptySet() extends IntSet {
  override def contains(x: Int): Boolean = false
  override def incl(x: Int): IntSet =
    new NonEmptySet(x, new EmptySet, new EmptySet)
  override def isEmpty: Boolean = true
  override def excl(x: Int) = this
  override def union(x: IntSet) = x union this
  override def intersection(x: IntSet) = x intersection this
}
case class NonEmptySet(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  override def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  override def incl(x: Int): IntSet =
    if (x < elem) new NonEmptySet(elem, left incl x, right)
    else if (x > elem) new NonEmptySet(elem, left, right incl x)
    else this
  override def isEmpty: Boolean = false
  override def union(x: IntSet) =
    /**do {
      if (x.isEmpty) this
      else if (x.contains(elem)) this.right.union(x)
      else this.right.union(x.incl(elem))
    } while (!this.right.isEmpty)
**/
      if (x.isEmpty) this
      else if (x.contains(elem)) this.right.union(x)
      else this.right.union(x.incl(elem))


  def intersection(x: IntSet) =
    /**do {
      if (x.isEmpty) this
      else if (x.contains(elem)) this.right.union(x)
      else this.right.union(x.excl(elem))
    } while (!this.right.isEmpty)
      **/
      if (x.isEmpty) this
      else if (x.contains(elem)) this.right.union(x)
      else this.right.union(x.excl(elem))



  override def excl(x: Int): IntSet =
    if (x < elem) left excl x
    else if (x > elem) right excl x
    else left union right
}

var mySet1 = NonEmptySet(1, EmptySet(), NonEmptySet(2, EmptySet(), EmptySet()))
mySet1.incl(3)
var mySet2 = EmptySet()
mySet2.incl(3)
mySet2.incl(4)
mySet2.incl(5)
println(mySet1)
println(mySet2)