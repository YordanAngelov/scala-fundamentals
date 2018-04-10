package app.models

import scala.collection.mutable.ArrayBuffer

object PetRepository {

  //  The below contains all of the subtypes of Pet, e.g. all of the classes or objects that extend it
  private val _pets: ArrayBuffer[Pet] = new ArrayBuffer[Pet]()

  val barry = Dog("Barry", 22)
  val kanye = Dog("Kanye", 22)
  val kendrick = Dog("Kendrick", 22)

  def all: List[Pet] = _pets.toList

  //  not working?
  def findByName(name: String): Option[Pet] = _pets.find(p ⇒ p.name == name)

  def dogs: List[Dog] = {
    _pets.toList.flatMap {
      case d @ Dog(_, _) ⇒ Some(d)
      case _ ⇒ None
    }
  }

  def cats: List[Cat] = {
    all.flatMap {
      case c @ Cat(_, _) ⇒ Some(c)
      case _ ⇒ None
    }
  }

  def other(): List[Pet] = {
    all.flatMap {
      case Cat(_, _) ⇒ None
      case Dog(_, _) ⇒ None
      case x @ _ ⇒ Some(x)
    }
  }

  //  * is syntax for varargs, e.g. various number of arguments(?)
  def add(pet: Pet*) = {
    _pets.appendAll(pet)
  }

//  def removeByName(pet: Pet): List[Pet] = {
//    _pets -= pet
//  }

//  def update(pet: Pet): List[Pet] = {
  // don't understand the requirement - perhaps _pets + pet
//  }

  add(barry, kendrick, kanye)

}
