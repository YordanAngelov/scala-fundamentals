package app

import utils.Helpers

import scala.io.StdIn

object Greeter extends App {

  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("What's your age? ")

  val p = new Person(name, age.toInt)

  println(p.speak())
  while(repeat) println(p.speak())

  def repeat(): Boolean = {
    val c = StdIn.readLine("Do you want to get another greeting? ")
    if(Helpers.affirmations.contains(c)) true
    else {
      println("Suit yourself")
      false
    }
  }

}


