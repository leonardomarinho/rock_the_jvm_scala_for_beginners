package exercises.generics

abstract class GenericMyList[+A] {
  def head: A
  def tail: GenericMyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericMyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends GenericMyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: GenericMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GenericMyList[B] = new Cons(element, this)
  def printElements: String = ""
}

class Cons[+A](h: A, t: GenericMyList[A]) extends GenericMyList[A]{
  def head: A = h
  def tail: GenericMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A] (element: B): GenericMyList[B] = new Cons(element, this)

  def printElements: String =
    if (tail.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App{
  val listOfIntegers: GenericMyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: GenericMyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)
}