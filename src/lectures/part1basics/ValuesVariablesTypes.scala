package lectures.part1basics

object ValuesVariablesTypes extends App {

  // compiler can infer types

  // vals are immutable
  val x: Int = 42
  val y = 45
  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = false
  val anotherBoolean = true

  val aChar: Char = 'a'
  val anInt: Int = 1
  val aShort: Short = 3334
  val aLong: Long = 11212223323900L
  val aFloat: Float = 2.0f
  val aDouble: Double = 2.15


  println(x, y, aString, anotherString, aBoolean, anotherBoolean, aChar, anInt, aShort, aLong, aFloat, aDouble)


  //VARIABLES
  var aVariable: Int = 4

  aVariable = 5


}
