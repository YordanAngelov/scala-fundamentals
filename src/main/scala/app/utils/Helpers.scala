package app.utils

object Helpers {

  val affirmations = List("yes", "yeah", "Yes", "y", "Yeah", "Yay", "k", "OK", "ok", "K")

}

class Calculator {

  def add(f: Int, g: Int) = f + g

  def add(f: Double, g: Double) = f + g

  def add(f: Int, g: Int, h: Int) = f + g + h

}