package app

import app.views.Prompt
import models.{CashISASavingsAccount, Person}
import utils.Helpers

import scala.io.StdIn

object Greeter extends App {

  val check = Prompt.ask("Who are you? ")
  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("What's your age? ")

  val cashisa = new CashISASavingsAccount("45676", 0.0, 1000.0)
  val deposited = cashisa.deposit(1000.00)
  val withdrawn = cashisa.withdraw(200.00)

  val normalAccount = new CashISASavingsAccount("12334", 100.00)
  val loyalAccountDeposited = normalAccount.deposit(300)

  val loyal = new Person("Loyal customer", 22, loyalAccountDeposited)
  val p = new Person(name, age.toInt, withdrawn)

  def checkUser(): Unit = if (check == "Secret") println(p.speak()) else println(loyal.speak())


  Prompt.reply(loyal.speak())

  def repeat(): Boolean = {
    val c = StdIn.readLine("Do you want to get another greeting? ")
    if(Helpers.affirmations.contains(c)) true
    else {
      println("Suit yourself")
      false
    }
  }

  val names = Array("Adam", "John", "Herman")
  val adam = names.head

}


