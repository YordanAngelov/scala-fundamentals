package app.models

//  A sealed trait can only be extended in the same file
sealed trait Pet {

  val name: String
  val age: Int

  def speak: String = "hello"

  //  Traits can have partial implementation

}

//  We use case classes when:
//  a) we want a class with immutable state
//  b) we don't want any logic within the case class, though it is possible to define methods within it
final case class Cat(name: String, age: Int) extends Pet {

  override def speak: String = "Meow!"

}

final case class Dog(name: String, age: Int) extends Pet {

  override def speak: String = "Woof!"

}

//  Case classes enable us to use:
//  a) apply(): using a set of arguments, we generate an Object of that type
//  b) unapply(): takes an instance of the class and decontructs it to expose its public properties as a Tuple
//  c) equals: compares instances of the case class based on structure, not reference; known as structural equality

object Dog {

  def withName(name: String) = new Dog(name, 2)
}

