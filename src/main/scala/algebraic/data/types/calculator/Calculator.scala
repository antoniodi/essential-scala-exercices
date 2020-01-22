package algebraic.data.types.calculator

sealed trait Expression {
  def eval: Calculation = {
    this match {
      case Number(value)            => Success(value)
      case Addition(left, right)    =>
        left.eval match {
          case Success(leftResult)  =>
            right.eval match {
              case Success(rightResult) => Success(leftResult + rightResult)
              case Failure(reason) => Failure(reason)
            }
          case Failure(reason) => Failure(reason)
        }
      case Subtraction(left, right) =>
        left.eval match {
          case Success(leftResult)  =>
            right.eval match {
              case Success(rightResult) => Success(leftResult - rightResult)
              case Failure(reason) => Failure(reason)
            }
          case Failure(reason) => Failure(reason)
        }
      case Division(left, right)    =>
        left.eval match {
          case Success(leftResult)  =>
            right.eval match {
              case Success(0) => Failure("Error: Division by zero")
              case Success(rightResult) => Success(leftResult / rightResult)
              case Failure(reason) => Failure(reason)
            }
          case Failure(reason) => Failure(reason)
        }
      case SquareRoot(expression) =>
        expression.eval match {
          case Success(expressionResult) if (expressionResult >= 0) => Success(Math.sqrt(expressionResult))
          case _                                                    => Failure("Error: Square root error")
        }
    }
  }
}
case class Addition(left: Expression, right: Expression) extends Expression
case class Subtraction(left: Expression, right: Expression) extends Expression
case class Number(value: Double) extends Expression
case class Division(left: Expression, right: Expression) extends Expression
case class SquareRoot(expression: Expression) extends Expression

sealed trait Calculation
final case class Success(result: Double) extends Calculation
final case class Failure(reason: String) extends Calculation

case object testCalculator {
  def main(args: Array[String]): Unit = {
    val expressionOne = Number(10d)
    val expressionTwo = Number(0d)

    println(Addition(Division(Addition(expressionOne, expressionTwo), expressionTwo), expressionOne).eval)
  }
}