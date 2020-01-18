package algebraic.data.types

sealed trait Calculator
final case class Success(result: Int) extends Calculator
final case class Failure(reason: String) extends Calculator
