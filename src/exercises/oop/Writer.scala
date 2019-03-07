package exercises.oop

class Writer(firstName: String, surname: String, val year: Int) {

  def fullname(): String = s"$firstName $surname"

}