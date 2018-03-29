package app

class Person(name: String, age: Int, private val bankAccount: BankAccount) {

  def this(name: String, age: Int) = this(name, age, new SavingsAccount("12345", 0.00))

  private def years: String = if (age > 1) "years" else "year"

  def speak(): String = {
    if (name == "Adam") {
      "You don't get a hello!"
    } else {
      println(s"Hello $name, you are $age $years old!")
      if (age < 20) "How are you doing, fellow kid?"
      else if (age >= 20 & age < 40) s"Since you are $age old, you must be a respectable professional.\n" +
        s"You have ${bankAccount.balance} in your account."
      else "Do you know Matt?"
    }
  }

}

abstract class BankAccount(accountNumber: String, val balance: Double) {

  def withdraw(amount: Double): BankAccount

  def deposit(amount: Double): BankAccount

}

final class SavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {
    if ((balance - amount) < 0) {
      println("You have insufficient funds!")
      this
    } else {
      val deducted = balance - amount
      println(s"Balance after deductions: $deducted")
      new SavingsAccount(accountNumber, deducted)
    }
  }

  override def deposit(amount: Double): BankAccount = {
    new SavingsAccount(accountNumber, balance + amount)
  }

}

final class CashISASavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {
    println(s"You can't withdraw yet mate, it has been less than an hour than you deposited! Chill!")
    this
  }

  override def deposit(amount: Double): BankAccount = {
    new CashISASavingsAccount(accountNumber, balance + amount)
  }

}