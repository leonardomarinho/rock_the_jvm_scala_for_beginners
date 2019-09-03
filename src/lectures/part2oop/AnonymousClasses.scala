package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  // Anonymous class
  // You can instantiate types and override methods or fields on the spot
  // You need to pass in required constructor arguments if needed
  // When instantiating an abstract class you must implement all abstract fields/methods
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("Chomp, chomp")
  }

  /*
  equivalent with

  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = println("Chomp, chomp")
  }

  val funnyAnimal: Animal = new AnonymousClasses$$anon$1
  */

  println(funnyAnimal.eat)

  class Person(name: String){
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, I'm Jim. How can I be of service?")
  }
}
