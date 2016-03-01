
abstract class Nat {
  def isZero: Boolean
  def predecessor: Nat
  def successor: Nat
  def +(that: Nat): Nat
  def -(that: Nat): Nat
}
case class Integer(x:Int, s: Sign) extends Nat{
  override def isZero: Boolean = false
  override def predecessor: Nat = this
  override def successor: Nat = this
  override def +(that: Nat): Nat = this
  override def -(that: Nat): Nat = this
  def isPositive: Boolean = if (s.sign.equals("+")) true else false
  def negate: Integer =
  if (this.isPositive) Integer(x, new Sign("-")) else Integer(x, new Sign("+"))
}
class Sign(val sign: String)
/**
//Positive numbers
class Succ(x: Nat) extends Nat with Integer{
  override def isZero: Boolean = false
  override def predecessor: Nat = x
  override def successor: Nat = new Succ(this)
  override def +(that: Nat): Nat = x + that.successor
  override def -(that: Nat): Nat = if (that.isZero) this
  else x - that.predecessor
}
//Negative numbers
class Pred(x: Nat) extends Nat with Integer{
  override def isZero: Boolean = false
  override def predecessor: Nat = x
  override def successor: Nat = new Pred(this)
  override def +(that: Nat): Nat = x + that.successor
  override def -(that: Nat): Nat = if (that.isZero) this
  else x - that.predecessor
}
object Zero extends Nat with Integer{
  override def isZero: Boolean = true
  override def predecessor: Nat = sys.error("negative number")
  override def successor: Nat = new Succ(Zero)
  override def +(that: Nat): Nat = that
  override def -(that: Nat): Nat = if (that.isZero) Zero
  else sys.error("negative number")
}
  **/


