package lectures.part2oop

import exercises.oop.{Counter, Novel, Writer}

object OOBasics extends App{
  val person: Person = new Person("John", 26)
  val anotherPerson = new Person("Lisa")
  println(person.age)
  person.greet("Daniel")
  person.greet()
  anotherPerson.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, impostor)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))


  val counter = new Counter
  println(counter.increment.count)
  println(counter.increment(10).count)

  println(counter.decrement.count)
  println(counter.decrement(10).count)
}

//constructor
//adding val before the parameter turns it into a field
class Person(name: String, val age: Int) {

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")
  def greet(): Unit = println(s"Hi, I am $name")

  //another constructor
  def this(name: String) = this(name, 0)
}

//class parameters are NOT FIELDS