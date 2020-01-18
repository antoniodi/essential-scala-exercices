package `trait`

object divide {

  def apply(numerador: Double, denominador: Double): DivisionResult = (numerador, denominador) match {
    case (_, 0) => new Infinite
    case (numerador, denominador)    => Finite(numerador / denominador)
  }

}

sealed trait DivisionResult

case class Finite(result: Double) extends DivisionResult

case class Infinite()  extends DivisionResult
