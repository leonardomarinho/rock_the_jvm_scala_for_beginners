package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  println(aFunction("hello", 3))

  def aParameterlessFunction(): Int =  42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  // WHEN YOU NEED LOOPS USE RECURSION.

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + " " + (aRepeatedFunction(aString, n-1))
  }

  println(aRepeatedFunction("hello", 3))



  def aFunctionWithSideEffect(aString: String): Unit = println(aString)

  def aBigfunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  def greetingFunction(name: String, age: Int): String = "Hi, my name is " + name + "and I am " + age + " years old."
  println(greetingFunction("Leonardo", 15))

  def factorialFunction(n: Int): Int =
    if (n <= 0) 1 else n * factorialFunction(n - 1)

  println(factorialFunction(10))

  def fibonacciFunction(n: Int): Int =
    if (n <= 2) 1 else fibonacciFunction(n - 1) + fibonacciFunction(n - 2)

  println(fibonacciFunction(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil (t: Int): Boolean =
      if(t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }

  println(isPrime(7))
  println(isPrime(49))
  println(isPrime(37))

}
