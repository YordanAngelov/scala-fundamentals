package app.models

import scala.collection.mutable.ArrayBuffer

object PetRepository {

  //  The below contains all of the subtypes of Pet, e.g. all of the classes or objects that extend it
  private val _pets: ArrayBuffer[Pet] = new ArrayBuffer[Pet]()

  def all(): List[Pet] = _pets.toList

  def findByName(name: String): Option[Pet] = None

  def dogs(): List[Pet] = _pets.toList

  def cats(): List[Pet] = _pets.toList

  def other(): List[Pet] = _pets.toList

//  * is syntax for varargs, e.g. random arguments(?)
  def add(pet: Pet*): List[Pet] = _pets.toList

  def removeByName(name: String): List[Pet] = _pets.toList

  def update(pet: Pet): List[Pet] = _pets.toList

}
