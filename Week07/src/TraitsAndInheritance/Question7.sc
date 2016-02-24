
trait Manuscript {
  def length: Int
  def author: String
}

trait Issue{
  def volume:Int
  def number:Int
  def manuscripts: Seq[Manuscript]
}

//Sum data type: Publication is a Book or Periodical
sealed trait Publication
 final case class Book(length: Int, author: String) extends Manuscript with Publication
 final case class Periodical (editor: String, issues: List[Issue]) extends Publication

