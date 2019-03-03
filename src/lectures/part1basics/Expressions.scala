package lectures.part1basics

object Expressions extends App{

  val x = 1 + 2
  println(x)

  println(2 + 3 * 4)

  println(1 == x)

  println(!(1 == x))

  var aVariable = 2
  aVariable += 3

  println(aVariable)


  //Instructions vs Expressions
  //Instructions tell the computer to DO something
  //Expressions tell the computer to EVALUATE a value


  val aCondition = false

  val aConditionedValue = if (aCondition) 5 else 3 //if EXPRESSION not an if INSTRUCTION

  println(aConditionedValue)
  println(if(aCondition) 8 else 9)

  var i = 0
  while(i < 10){
    println(i)
    i +=1
  }

  // NEVER WRITE THIS AGAIN!!!!

  // EVERYTHING in Scala is an Expression


  val aWeirdValue = (aVariable = 3) //Unit == void
  println(aWeirdValue)

  // side-effects are expressions that return a Unit. ie: println(), whiles, reassigning

  //Code blocks
  // The value of a code block is always it's last expression
  val aCodeBlock = {
    val x = 2
    val y = x + 1

    if (y > 2) "hello" else "goodbye"
  }

  println(aCodeBlock)

  val someValue = {
    2 < 3
  }

  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }

  println(someOtherValue)
}
