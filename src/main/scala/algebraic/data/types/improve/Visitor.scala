package algebraic.data.types.improve

trait Visitor {
  def sendEmail(visitor: Visitor) = EmailService.sendEmail(visitor)
}

case class Anonymous() extends Visitor
case class User() extends Visitor

case object EmailService {
  def sendEmail(visitor: Visitor) = {
    visitor match {
      case visitor: User      => "send email"
      case visitor: Anonymous => "Only sign-in users can send emails"
    }
  }
}