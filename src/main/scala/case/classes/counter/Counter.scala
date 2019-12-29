package `case`.classes.counter

case class Counter(count : Int = 0) {
  def inc : Counter = inc()
  def dec : Counter = inc()
  def inc(amount : Int = 1) : Counter = copy(count = count + amount)
  def dec(amount : Int = 1) : Counter = copy(count = count - amount)
}
