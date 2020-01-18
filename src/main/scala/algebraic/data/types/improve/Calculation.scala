package algebraic.data.types.improve

object Calculator {
  def +(aCalculation: Calculation, value: Int): Calculation = {
    aCalculation match {
      case Success(result) => Success(result + value)
      case Failure(_) => aCalculation
    }
  }

  def -(aCalculation: Calculation, value: Int): Calculation = {
    aCalculation match {
      case Success(result) => Success(result - value)
      case Failure(_) => aCalculation
    }
  }

  def /(aCalculation: Calculation, value: Int): Calculation = {
    aCalculation match {
      case Success(result)   => divide(value, result)
      case Failure(_)        => aCalculation
    }
  }

  private def divide(value: Int, result: Int) = {
    value match {
      case 0 => Failure("Division by zero")
      case _ => Success(result / value)
    }
  }
}

sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

object main {
  def main(args: Array[String]): Unit = {
    println(Calculator.+(Success(5), 5))
    println(Calculator.+(Failure("asd"), 5))
  }
}