package app.models

class Person(name: String, age: Int, private val bankAccount: Seq[BankAccount] = Nil) {

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

//  Creating a list; Nil must be included at the end or it won't work
  private val excluded = "Adam" :: "Daniel" :: "Yordan" :: Nil

  val firstElement: String = excluded.head

  val restOfElements: List[String] = excluded.tail

  val specificElement = excluded(2)

//  Creating a set - removes duplicate values when initialised,
//  e.g. Set("adam", "byron", "chris", "byron") will become
//  Set("adam", "byron", "chris")
  private val exampleSet = Set("Adam", "Johnny", "Jimmy", "Ricky", "Micky", "Ricky")

//  The below will return all the characters in the set
  exampleSet.flatten

//  Creating an empty Map
  val emptyfruits: Map[String, String] = Map()

//  Creating and using a Map
  val testFruits: Map[String, String] = Map(
    "orange" → "orange",
    "banana" → "yellow",
    "apple" → "red"
  )

  val colour: String = testFruits("banana")  // will return yellow
  testFruits.keys                            // returns all the keys
  testFruits.values                          // returns all the values
  testFruits.isEmpty                         // returns a boolean depending on whether the list is empty

}
