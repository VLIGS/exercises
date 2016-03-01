
sealed trait DivisionResult
case class Finate(val arg: Int) extends DivisionResult
case class Infinate() extends DivisionResult
case object divide{
  def apply(arg1: Int, arg2:Int):DivisionResult = if (arg2 == 0) Infinate() else Finate(arg1/arg2)
}

divide(1, 2) //res0: DivisionResult = Finate(0)
divide(1, 0) //res1: DivisionResult = Infinate()