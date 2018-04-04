package app.models

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
