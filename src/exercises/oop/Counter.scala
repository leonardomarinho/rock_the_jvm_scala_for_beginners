package exercises.oop

class Counter(value: Int = 0) {
  def count = value

  def increment = new Counter(value + 1)
  def decrement = new Counter(value - 1)

  def increment(amount: Int): Counter = {
    if (amount <= 0) this
    else increment.increment(amount - 1)
  }

  def decrement(amount: Int): Counter = {
    if (amount <= 0) this
    else decrement.decrement(amount - 1)
  }
}
