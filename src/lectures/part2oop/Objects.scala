package lectures.part2oop

object Objects {

  //Scala does not have class-level functionality ("static")
  object Person { // type + its only instance
    // "static" or "class" level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    //factory method
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")
  }

  class Person(name: String) {
    // instance level functionality
  }

  //COMPANIONS
  // In Scala a class has instance level functionality,
  // while an object is a singleton and has static or class level functionality
  // When you have a class and object with the same name they act as 'Companions' of each other

  def main(args: Array[String]): Unit = {

    println (Person.N_EYES)
    println (Person.canFly)

    //Scala object is a singleton
    val mary = Person
    val john = Person
    println (mary == john)

    val alice = new Person ("Alice")
    val bob = new Person ("Bob")
    println (alice == bob)

    val bobbie = Person(alice, bob)

  }

  // Scala objects:
  // Are in their own class
  // are the only instance
  // singleton pattern

  // Scala companions:
  // can access each other's private members

  // Scala Applications = Scala object with
  // def main(args: Array[String]): Unit

}
