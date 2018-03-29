package app

import utils.Helpers

import scala.io.StdIn

object Greeter extends App {

  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("What's your age? ")

  val cashisa = new CashISASavingsAccount("45676", 0.0)
  val deposited = cashisa.deposit(1000.00)
  val withdrawn = cashisa.withdraw(200.00)

  val p = new Person(name, age.toInt, withdrawn)

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


