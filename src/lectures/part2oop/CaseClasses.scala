package lectures.part2oop

object CaseClasses extends App {

  /*
    equals, hashCode, toString
    Quick and lightweight data structures with little boilerplate
   */

  case class Person(name: String, age: Int)

  // 1. Class parameters are field
  val jim = (new Person("Jim", 34))
  println(jim.name)

  // 2. Sensible toString
  // println(instance) = println(instance.toString)
  println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person ("Jim", 34)
  println(jim == jim2)
  println(jim.equals(jim2))

  // 4. Case classes have a handy copy method
  val jim3 = jim.copy()
  val jim4 = jim.copy(age = 45)

  println(jim3)
  println(jim4)

  // 5. Case classes have companion objects by default
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Case classes are serializable

  // 7. Case Classes have extractor patterns. So They can be used in pattern matching

  // Scala also provides case objects. They behave the same as classes but without the companion object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }
}
