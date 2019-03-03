package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorialFunction(n: Int): Int =
    if (n <= 0) 1 else n * factorialFunction(n - 1)


  def anotherFactorial(n: Int): BigInt = {

    //This annotations forces the compiler to check for tail recursion within the function.
    // If it's not recursive the compiler with signal with an error.
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x -1, x * accumulator) // TAIL RECURSION = use recursive call as the LAST expression

    factorialHelper(n, 1)
  }

  println(anotherFactorial(5000))


  // WHEN YOU NEED LOOPS USE _TAIL_ RECURSION.

  def stringConcatenation(string: String, times: Int): String = {
    def concatenationHelper(string: String, accumulator: String, times: Int): String = {
      if (times <= 1) accumulator
      else concatenationHelper(string, accumulator + " " + string, times - 1)
    }
    concatenationHelper(string, string, times)
  }

  println(stringConcatenation("aaa", 9))


  def isPrime(originalValue: Int): Boolean ={
    def isPrimeHelper(currentValue: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (currentValue <= 1) true
      else isPrimeHelper(currentValue - 1, originalValue % currentValue != 0 && isStillPrime)
    }

    isPrimeHelper(originalValue / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(23))
  println(isPrime(20))

  def fibonacci(n: Int): Int = {
    def fiboTailRec(i: Int, last: Int, nextToNext: Int): Int = {
      if (i >= n) last
      else fiboTailRec(i + 1, last + nextToNext, last)
    }

    if (n <= 2) 1
    else fiboTailRec(2, 1, 1)
  }

  println(fibonacci(8))

}
