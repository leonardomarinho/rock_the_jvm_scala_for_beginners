package lectures.part2oop

object Inheritance extends App {

  class Animal{
    def eat: Unit = println("Nhom, nhom, nhom")
    private def privateEat: Unit = println("Nhom, nhom, nhom")
    protected def protectedEat: Unit = println("Nhom, nhom, nhom")
    val creatureType = "Wild"
  }

  class Cat extends Animal {
    def crunch = {
      this.protectedEat
      println("crunch, crunch, crunch")
    }
  }

  val myCat = new Cat
  myCat.eat
  myCat.crunch

  //Constructors
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int) extends Person(name)


  //Overriding
  class Dog(override val creatureType: String) extends Animal{
    override def eat: Unit = {
      super.eat
      println("Yummy, yummy")
    }
    //Another solutions to overriding
    //override val creatureType: String = "Domestic"
  }

  println(new Dog("K9").creatureType)

  //Polymorphism
  val myAnimal: Animal = new Dog("Wild")
  myAnimal.eat

  //overRIDING vs overLOADING
  // Overriding is to supply different implementations in derived classes
  // Overloading is providing different signatures and implementations for the same method in the same class


  // Preventing override
  // 1. Use the keyword final on member
  // 2. Use the keyword final on the class to prevent it from being extended
  // 3. Use the keyword sealed on the class = you can extend the class in THIS FILE only

}
