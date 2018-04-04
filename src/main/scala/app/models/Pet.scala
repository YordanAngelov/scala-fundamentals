package app.models

//  A sealed trait can only be extended in the same file
sealed trait Pet {

  val name: String
  def speak: String

//  Traits can have partial implementation

}

//  We use case classes when:
//  a) we want a class with immutable state
//  b) we don't want any logic within the case class, though it is possible to define methods within it
final case class Cat(name: String) extends Pet{

  override def speak: String = "Meow!"

}

final case class Dog(name: String, private val personYears: Int) extends Pet{

  override val speak: String = "Woof!"

  import Dog._
  def age = calculateAgeInDogYears(personYears)

}

//  Case classes enable us to use:
//  a) apply(): using a set of arguments, we generate an Object of that type
//  b) unapply(): takes an instance of the class and decontructs it to expose its public properties as a Tuple
//  c) equals: compares instances of the case class based on structure, not reference; known as structural equality

object Dog {

  def withName(name: String) = new Dog(name, 2)

  private def calculateAgeInDogYears(age: Int) = age*7

}

