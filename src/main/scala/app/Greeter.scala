package app

import scala.io.StdIn

object Greeter extends App {

  def greet(n: String): Unit = println(s"Hello $n!")

  val name = StdIn.readLine("What is your name? ")

  greet(name)

}
