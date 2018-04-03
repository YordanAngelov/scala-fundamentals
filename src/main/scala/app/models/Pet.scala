package app.models

import scala.collection.mutable.ArrayBuffer

//  A sealed trait can only be extended in the same file
sealed trait Pet {

  val name: String
  def speak: String

//  Traits can have partial implementation

}

final class Cat extends Pet{

  override val name: String = "Cat"
  override def speak: String = "Meow!"

}

final class Dog extends Pet{

  override val name: String = "Dog"
  override val speak: String = "Woof!"

//  The below contains all of the subtypes of Pet, e.g. all of the classes or objects that extend it
  private val _pets: ArrayBuffer[Pet] = new ArrayBuffer[Pet]()

}

