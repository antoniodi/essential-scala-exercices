package algebraic.data.types.calculator

sealed trait ExpressionV1 {
  def eval: Double
}
case class AdditionV1(left: ExpressionV1, right: ExpressionV1) extends ExpressionV1 {
  override def eval: Double = left.eval + right.eval
}
case class SubtractionV1(left: ExpressionV1, right: ExpressionV1) extends ExpressionV1 {
  override def eval: Double = left.eval - right.eval
}
case class NumberV1(value: Double) extends ExpressionV1 {
  override def eval: Double = value
}
case class DivisionV1(left: ExpressionV1, right: ExpressionV1) extends ExpressionV1 {
  override def eval: Double = {
    val leftValue = left.eval
    val rightValue = right.eval
    if (rightValue == 0) {???} else {leftValue / rightValue}
  }
}
case class SquareRootV1(expression: ExpressionV1) extends ExpressionV1 {
  override def eval: Double = {
    val expressionValue = expression.eval
    if (expressionValue < 0d) {???} else Math.sqrt(expressionValue)
  }
}
case class Fail() extends ExpressionV1 {
  override def eval: Double = ???
}

case object ExpressionV1Operation {
  def eval(expression: ExpressionV1): Double = {
    expression match {
      case NumberV1(value)            => value
      case AdditionV1(left, right)    => eval(left) + eval(right)
      case SubtractionV1(left, right) => eval(left) - eval(right)
      case DivisionV1(left, right)    => {
        val rightValue = right.eval
        rightValue match {
          case 0 => ???
          case _ => left.eval / rightValue
        }
      }
      case SquareRootV1(expression) => {
        val expressionValue = expression.eval
        expressionValue match {
          case expression if (expression >= 0) => Math.sqrt(expressionValue)
          case _               => ???
        }
      }
    }
  }
}


sealed trait CalculationV1
final case class SuccessV1(result: Double) extends CalculationV1
final case class FailureV1(reason: String) extends CalculationV1
