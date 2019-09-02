package lectures.part2oop

object Generics extends App {

  class MyList[A] {
    //use the type A
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList{
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]


  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Covariance -> Yes, a List[Cat] extends List[Animal]
  // Use the + before the type
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) ??? Hard Question. It would polute the list mixing cats and dogs

  // Invariance = No, List[Cat] does NOT extends List[Animal]
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // Contravariance = Hell, no!
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // bounded types
  // Class Cage accepts any Type A that is a subtype of Animal
  // use <: for subtype and >: to supertype
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Dog)



}
