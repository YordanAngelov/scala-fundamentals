package app

import app.models._
import app.views.Prompt

object Greeter {

  val check = Prompt.ask("Who are you? ")
  val name = Prompt.ask("What is your name? ")
  val age = Prompt.ask("What's your age? ")

  val cashisa = new CashISASavingsAccount("45676", 0.0, 1000.0)
  val deposited = cashisa.deposit(1000.00)
  val withdrawn = cashisa.withdraw(200.00)

  val normalAccount = new CashISASavingsAccount("12334", 100.00)
  val loyalAccountDeposited = normalAccount.deposit(300)

  val loyal = new Person("Loyal customer", 22, List(loyalAccountDeposited))
  val p = new Person(name, age.toInt, List(withdrawn))
  //  We could use LinearSeq instead of List if we are not as concerned for single elements in the list,
  //  e.g. summing up all the bank accounts, or IndexedSeq if we are going to access the list at a random index,
  //  e.g. withdrawing or depositing money to a specific bank account

  //  def checkUser(): Unit = if (check == "Secret") println(p.speak()) else println(loyal.speak())

  //  Prompt.reply(loyal.speak())

  //  def repeat(): Boolean = {
  //    val c = StdIn.readLine("Do you want to get another greeting? ")
  //    if(Helpers.affirmations.contains(c)) true
  //    else {
  //      println("Suit yourself")
  //      false
  //    }
  //  }

  val names = List("Adam", "John", "Herman", "Humpty Dumpty")
  val ages = List(1, 20, 25, 40)
  val adam = names.head

  //  For loops
  for (name ← names) println(name)
  for (a ← 1 to 10) println(s"Value of: $a") // prints from 1 up to and including 10
  for (a ← 1 until 10) println(s"Value of: $a") // prints from 1 up to, but not including 10

  val Range = 1 to 20
  for (a ← Range if a != 3; if a != 5) {
    println(a)
  }

  def practiceSingleElementForFilters(): Unit = {
    val filtered = for (
      name ← names if name != "Adam"; if name != "Herman"
    ) yield name

    println(filtered)
  }

  //  The below is a nested loop
  def practiceMultipleElementsForFilters(): Unit = {
    val filtered = for (
      name ← names if name != "John"; if name != "Herman";
      age ← ages
    ) yield s"name $name, age: $age"

    println(filtered)
  }

  practiceMultipleElementsForFilters()

  //  Tuple example; the upper limit of objects a tuple can hold is *currently* 22
  //  Anything beyond that will require you to use a collection
  val t: (Int, String, Person) = (1, "hello", new Person("John Doe", 21))

  val number = t._1 // returns the 1st element, e.g. 1
  val string = t._2 // returns the 2nd element, e.g. hello
  val person = t._3 // returns the 3rd element, e.g. Person("John Doe", 21)

  //  You can also use tuple.foreach
  t.productIterator.foreach(x ⇒ println(x))

  val doggo = Dog.withName("Bruce Banner").age

  //  Pattern matching - can be used for:
  //  primitive types, e.g. String, Int, etc.,
  //  type of an object, e.g. Pet, etc.,
  //  case classes,
  //  etc.
  val numero = 1

  def intToString(n: Int): String = n match {
    case 0 ⇒ "zero"
    case 1 ⇒ "one"
    case 2 ⇒ "two"
    case _ ⇒ "above two"
  }

  intToString(numero)

  val d = Dog("Geoff", 35)
  val barry = Dog("barry", 2)

  def isDog(pet: Pet): Boolean = pet match {
    case d: Dog ⇒ true
    case c: Cat ⇒ false
    case _ ⇒ false // right now, there are only classes of pets (dog and cat) so this is obsolete
  }

  isDog(d)

  //  In this case, we are saying that when we deconstruct out Pet, we do not want to assign the age to a variable
  //  as we are not going to use it. Hence, we replace it with _. Basically, we don't care about it, because we don't use it
  //  in this function.
  //  The first case statement has a guard which checks if the name value equals geoff
  def whoDis(pet: Pet) = pet match {
    case Dog(name, age) if name.equalsIgnoreCase("geoff") ⇒ s"This is top dog, my name is $name, give me your lunch!" +
      s" I am the eldest at $age years old.".stripMargin
    case Dog(name, _) ⇒ s"This is $name, I am only a dog."
    case Cat(name, _) ⇒ s"This is a cat, and their name is $name."
  }

  whoDis(d)
  whoDis(barry)

  val c: Option[Pet] = Some(Cat("Tom", 3))
  val n: Option[Pet] = None

  n.isEmpty // will return true
  c.isDefined // will return true (it's calling a different value) - opposite of isEmpty

  val x: Pet = c.get // returns Cat("Tom", 3)
  val y: Pet = n.get // returns NoSuchElementException

  // ***************************
  // *** ANONYMOUS FUNCTIONS ***
  // ***************************
  val bankList: List[BankAccount] = List(cashisa, normalAccount)

  //  This line...
  bankList.foldLeft(0.00)((accumulator, BankAccount) ⇒ accumulator + BankAccount.balance)

  //  ... equals this
  def add(acc: Double, account: BankAccount) = acc + account.balance

  bankList.foldLeft(0.00)((acc, account) ⇒ add(acc, account))

  // A nicer implementation would be
  val addition = (acc: Double, account: BankAccount) ⇒ acc + account.balance
  bankList.foldLeft(0.00)(addition)

  // An even simpler implementation
  def totalBalance = bankList.map(_.balance).sum

  // ******************************
  // *** HIGHER ORDER FUNCTIONS ***
  // ******************************
  def sumAndMultipleBy(f: Double => Double) = bankList.map(x => f(x.balance)).sum

  Prompt.reply(person.sumAndMyltipleBy(_ * 2))

  // *************************
  // *** PARTIAL FUNCTIONS ***
  // *************************
  // Every partial function must implement an apply and isDefinedAt method, where:
  // a) apply() is the function that gets called when passing in a value to the function call, i.e.
  // def(0) is the same as def.apply(0)
  // b) isDefinedAt is the function which checks if the input can be accepted by the function, i.e.
  // can we pass 0 as a parameter to the function. This returns a Boolean value
  val divide = new PartialFunction[Int, Int] {
    def apply(x: Int) = 42/x
    def isDefinedAt(x: Int): Boolean = x != 0
  }

  // A more concise way to rewrite the previous code is:
  val divide : PartialFunction[Int, Int] = {
    case d: Int if d != 0 ⇒ 42 / d
  }

  List(0, 1, 2, 3, 4).map(divide) // this would fail as there isn't a case statement in divide that handles 0
  List(0, 1, 2, 3, 4).collect(divide) // collect calls isDefinedAt() method first before mapping - if the input cannot be handle, collect discards it from the collection and continues

  val isEven: PartialFunction[Int, String] = {
    case x: Int if x % 2 == 0 ⇒ s"$x is even"
  }

  val isOdd: PartialFunction[Int, String] = {
    case x: Int if x % 2 == 1 ⇒ s"$x is odd"
  }

  val numbers = 1 to 5
  val evenNumbers = numbers collect isEven
  val isEvenOrOdd = isEven orElse isOdd

  val allNumbers: IndexedSeq[String] = numbers map isEvenOrOdd

  val double = (n: Int) ⇒ n * 2
  val plusOne = (n: Int) ⇒ n + 1

  // PartialFunctions also have a compose and andThen function
  // andThen executes the first function, then executes the second one
  val doublePlusOne = double andThen plusOne
  // compose executes the first function for each element in the list, then passing on that value to the second function, e.g.
  // instead of double + plusOne, it will be double(plusOne)
  val doublePlusOne = double compose plusOne

  val numberList = List(1, 2, 3, 6, 8, 12, 45, 68)
  numberList.map(doublePlusOne)
  numberList.foldLeft(0){
    (z,i) ⇒ z + i * 2
  }

}
