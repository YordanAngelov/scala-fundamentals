package app.models

final class CashISASavingsAccount(accountNumber: String, balance: Double, private val depositThreshold: Double = 200.00)
  extends BankAccount(accountNumber, balance) {

    override def withdraw(amount: Double): BankAccount = {
      println(s"You can't withdraw yet mate, it has been less than an hour than you deposited! Chill!")
      this
    }

    override def deposit(amount: Double): BankAccount = {
      if (amount > depositThreshold) {
        val difference = amount - depositThreshold
        println(s"You can't deposit more than £$depositThreshold. Excess: £$difference.")
        new CashISASavingsAccount(accountNumber, balance + depositThreshold)
      } else {
        new CashISASavingsAccount(accountNumber, balance + amount)
      }
    }

  }
