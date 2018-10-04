package app

import app.models.{Cat, Dog, Pet}

import scala.collection.mutable.ArrayBuffer

object PetRepository {

  private val _pets : ArrayBuffer[Pet] = new ArrayBuffer[Pet]()

  def all() : List[Pet] = _pets.toList

  def findByName(name : String) : Option[Pet] = _pets.find(p => p.name.equalsIgnoreCase(name))

  def dogs : List[Dog] = {
    _pets.toList.collect { case d : Dog => d }
  }

  def cats : List[Cat] = {
    _pets.toList.flatMap {
      case c @ Cat(_, _) => Some(c)
      case _ => None
    }
  }

  def other : List[Pet] = _pets.toList.filterNot(x => x.isInstanceOf[Cat] || x.isInstanceOf[Dog])

  def add(pet: Pet*) : List[Pet] = {
    _pets ++= pet

    all()
  }

  def removeByName(name : String) : List[Pet] = _pets.toList.filterNot(p => p.name.equalsIgnoreCase(name))

  def update(original: Pet, modified: Pet) : List[Pet] = {
    _pets.update(indexOfPet(original), modified)

    all()
  }

  private def indexOfPet(pet: Pet) = _pets.indexOf(pet)

}
