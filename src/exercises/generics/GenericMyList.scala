package exercises.generics

abstract class GenericMyList[+A] {
  def head: A
  def tail: GenericMyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): GenericMyList[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"

  def map[B](transformer: MyTransformer[A, B]): GenericMyList[B]
  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]): GenericMyList[B]
  def filter(predicate: MyPredicate[A]): GenericMyList[A]

  // concatenation
  def ++[B >: A](list: GenericMyList[B]): GenericMyList[B]
}

case object Empty extends GenericMyList[Nothing]{
  def head: Nothing = throw new NoSuchElementException
  def tail: GenericMyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): GenericMyList[B] = new Cons(element, this)
  def printElements: String = ""

  def map[B](transformer: MyTransformer[Nothing, B]): GenericMyList[B] = Empty
  def flatMap[B](transformer: MyTransformer[Nothing, GenericMyList[B]]): GenericMyList[B] = Empty
  def filter(predicate: MyPredicate[Nothing]): GenericMyList[Nothing] = Empty

  def ++[B >: Nothing](list: GenericMyList[B]): GenericMyList[B] = list
}

case class Cons[+A](h: A, t: GenericMyList[A]) extends GenericMyList[A]{
  def head: A = h
  def tail: GenericMyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A] (element: B): GenericMyList[B] = new Cons(element, this)

  def printElements: String =
    if (tail.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1,2,3].map(n * 2)
    = new Cons(2, [2,3].map(n * 2))
    = new Cons(2, new Cons(4, [3].map(n * 2)))
    = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
    = new Cons(2, new Cons(4, new Cons(6, Empty)))
   */
  def map[B](transformer: MyTransformer[A, B]): GenericMyList[B] =
    new Cons(transformer.transform(h), t.map(transformer))

  /*
    [1, 2].flatmap(n => [n, n + 1])
    = [1, 2] ++ [2].flatmap(n => [n, n+1])
    = [1, 2] ++ [2, 3] ++ Empty.flatmap(n => n+1)
    = [1, 2] ++ [2, 3] ++ Empty
    = [1, 2, 2, 3]
   */
  def flatMap[B](transformer: MyTransformer[A, GenericMyList[B]]): GenericMyList[B] =
    transformer.transform(h) ++ t.flatMap(transformer)

  /*
  [1, 2, 3].filter(n % 2 == 0) =
    [ 2, 3].filter(n % 2 == 0) =
    = new Cons(2, [3].filter(n % 2 == 0))
    = new Cons(2, Empty.filter(n % 2 == 0))
    = new Cons(2, Empty)
   */
  def filter(predicate: MyPredicate[A]): GenericMyList[A] =
    if (predicate.test(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
    [1,2] ++ [3, 4, 5]
    = new Cons(1, [2] ++ [3, 4, 5])
    = new Cons(1, new Cons(2, Empty ++ [3, 4, 5])
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  def ++[B >: A](list: GenericMyList[B]): GenericMyList[B] = new Cons(h, t ++ list)
}

object ListTest extends App{
  val listOfIntegers: GenericMyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: GenericMyList[String] = new Cons("Hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int =  elem * 2
  }))

  println(listOfIntegers.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }))

  println(listOfIntegers ++ listOfIntegers)

  println(listOfIntegers.flatMap(new MyTransformer[Int, GenericMyList[Int]] {
    override def transform(elem: Int): GenericMyList[Int] = new Cons(elem, new Cons[Int](elem + 1, Empty))
  }))
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}