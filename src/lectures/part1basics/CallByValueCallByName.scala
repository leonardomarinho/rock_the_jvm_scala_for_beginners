package lectures.part1basics

object CallByValueCallByName extends App {

  //By Value avalia o parâmetro assim que recebe e usa ele ao longo de toda a função
  //Usa o mesmo valor sempre
  def callByValue(x: Long): Unit ={
    println("by value: " + x);
    println("by value: " + x);
  }


  //By Name recebe o parâmetro, mas só o avalia quando precisa usar consumindo assim menos recurso
  //Valor pode mudar ao longo da execução porque sempre que for usado ele será reavaliado
  def callByName(x: => Long): Unit ={
    println("by name: " + x)
    println("by name: " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  //This will crash since it will try to evaluate infinite in the begining
  printFirst(infinite(), 34)

  //This will run since it never uses the second parameter then it will never evaluate infinite()
  printFirst(34, infinite())

}
