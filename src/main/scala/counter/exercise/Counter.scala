package counter.exercise

class Counter(val count : Int) {
  def inc : Counter = inc()
  def dec : Counter = dec()
  def inc(inc : Int = 1) = new Counter(count + inc)
  def dec(dec : Int = 1) = new Counter(count - dec)
  def adjust(adder : Adder) = new Counter(adder.add(count))
}

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

