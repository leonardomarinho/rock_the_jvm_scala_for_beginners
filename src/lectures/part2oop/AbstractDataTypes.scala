package lectures.part2oop

object AbstractDataTypes extends App {

  //Abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal{
    val creatureType: String = "Canine"
    def eat: Unit = println("Crunch, Crunch")
  }

  val myDog = new Dog().eat


  //Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferedMeal: String = "Meat"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "Croc"
    def eat: Unit = println("Nhom, nhom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile

  crocodile.eat(dog)

  // Traits vs Abstract Classes
  // Abstract classes and Traits can have abstract and non-abstract members
  // Traits do not have constructor parameters
  // You can only extend one class but you can inherit multiple traits
  // Traits are behavior and an abstract class is a type of thing

}
