package lectures.part1basics

object StringOps extends App{

  val str: String = "Hello, I am learning Scala"

  //Basics
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)
  println(str.reverse)
  println(str.take(2))

  //Conversion
  val aNumberString = "45"
  val aNumber = aNumberString.toInt

  //Prepending and Appending
  println("a" +: aNumberString :+ "z")

  //s-interpolators
  val name = "Leonardo"
  val age = 28
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old"

  println(greeting)
  println(anotherGreeting)

  // f-interpolators
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burguers per minute"

  println(myth)

  // raw-interpolator - Ignores escaped characters inside a raw string but not inside a variable
  val escaped = "This is a \n and newline"

  println(raw"This is a \n and newline")
  println(escaped)
}
