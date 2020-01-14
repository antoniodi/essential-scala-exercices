package `trait`.cats

case class Cat(colour: String, food: String) extends Feline {

  override def sounds: String = "meow"
}
