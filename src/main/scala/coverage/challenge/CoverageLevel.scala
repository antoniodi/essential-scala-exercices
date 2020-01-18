package coverage.challenge

sealed trait Coverage {
  def coverageCode: String
}
sealed trait CoverageLevel
trait Offer extends CoverageLevel
trait Risk extends CoverageLevel
trait Article extends CoverageLevel

case class Subtraction() extends Coverage with Offer with Article {
  val coverageCode = ""
}
case object Subtraction {

}

object Validate {

  def apply(coverage: Coverage): String = {
    coverage match {
//      case coverage: Offer  if(apply[Offer](Offer, coverage.coverageCode))   => coverage.coverageCode
//      case coverage: Risk   if(apply(coverage.coverageCode))   => coverage.coverageCode
//      case coverage: Article if(apply(coverage.coverageCode))  => coverage.coverageCode
    }
  }

  def apply(coverageCode: String, obj: Class[_]): Boolean = {
    obj match {
      case obj : Offer     => true
      case obj : Risk    => true
      case coverageCode     => true
      case _ => false
    }
  }
}
