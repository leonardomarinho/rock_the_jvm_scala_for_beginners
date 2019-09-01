package exercises.inheritanceAndAbstractDataTypes

abstract class MyList {
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList{
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, this)
  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList{
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)

  def printElements: String =
    if (tail.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App{
  val list = new Cons(1, Empty)
  print(list.head)
  println(list.tail)
  println(list.isEmpty)

  val anotherList = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(anotherList.add(4).head)
  println(anotherList.toString)
}