class Cat(val color : String, val food : String)

class ChipShop() {
  def willServe(food : String): Boolean = {
    if("Chips" == food) true else false
  }
}

val oswald = new Cat("Black", "Milk")
val henderson = new Cat("Ginger", "Chips")
val quentin = new Cat("Tabby and white", "Curry")

val chipShop = new ChipShop()
chipShop.willServe(oswald.food)
chipShop.willServe(henderson.food)
chipShop.willServe(quentin.food)

