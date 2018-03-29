package app.models

class Person(name: String, age: Int, private val bankAccount: BankAccount) {

  def this(name: String, age: Int) = this(name, age, new SavingsAccount("12345", 0.00))

  private def years: String = if (age > 1) "years" else "year"

  def speak(): String = {
    if (excluded.contains(name)) {
      "You don't get a hello!"
    } else {
      println(s"Hello $name, you are $age $years old!")
      if (age < 20) "How are you doing, fellow kid?"
      else if (age >= 20 & age < 40) s"Since you are $age, you must be a respectable professional.\n" +
        s"You have ${bankAccount} in your account."
      else "Do you know Matt?"
    }
  }

  private val excluded = "Adam" :: "Daniel" :: "Yordan" :: Nil

}
