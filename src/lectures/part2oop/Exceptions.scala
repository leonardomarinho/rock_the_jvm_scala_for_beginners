package lectures.part2oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)

  // 1. Throwing Exceptions
  // throw new RuntimeException("It crashed")

  // Throwable classes extends the Throwable class.
  // Exception and Error are the major Throwable subtypes

  // 2. Catching Exceptions
  def getInt(withException: Boolean): Int = {
    if (withException) throw new RuntimeException("No int for you")
    else 42
  }

  try{
    getInt(true)
  } catch {
    case e: RuntimeException => println("Gotcha! Caught an Exception")
  } finally {
    println("finally")
  }

  // 3. Defining your own Exceptions
  class MyNiceException extends Exception
 // throw new MyNiceException


  // 4. Just playing
  // val array = Array.ofDim(Int.MaxValue)

  def infinite:Int = 1 + infinite

 // val stackOverflow = infinite


  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int) = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int) = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.divide(2, 0))

  class OverflowException extends Exception
  class UnderflowException extends Exception
  class MathCalculationException extends Exception

  println(PocketCalculator.add(1, 2))
  println(PocketCalculator.add(1, Int.MaxValue))
  println(PocketCalculator.subtract(2, 1))
  println(PocketCalculator.subtract(1, Int.MaxValue))
  println(PocketCalculator.add(1, 2))
}
