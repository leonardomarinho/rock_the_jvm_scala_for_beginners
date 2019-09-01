package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", this.favoriteMovie, this.age)

    def unary_! : String = "What the heck?!"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)

    def isAlive: Boolean = true

    def learns(something: String): String = s"${this.name} learns $something"
    def learnsScala(): String = learns("Scala")

    def apply(): String = s"Hi, I'm $name and I like $favoriteMovie"
    def apply(times: Int): String = s"Mary watched $favoriteMovie $times times"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") //Equivalent
  //infix notation = operator notation (syntactic sugar)

  // "Operators" in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  // ALL OPERATORS ARE METHODS IN SCALA
  println(1 + 2)
  println(1.+(2))

  //prefix notation
  val x = -1
  val y = 1.unary_- //equivalent

  println(!mary)
  println(mary.unary_!)

  // unary prefix only works with + - ~ !

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply
  // Whenever the compiler sees <Object>() it calls the apply method
  println(mary.apply())
  println(mary()) //Equivalent to apply()

  val newMary = mary + "The Rockstar"

  println(newMary.apply())

  println((+mary).age)

  println(mary learns "Python")
  println(mary learnsScala())

  println(mary apply(2))

}
