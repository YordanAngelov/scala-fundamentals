package app

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object IntegerComplexity extends App {

  def findSmallestValueOfFactors(): Unit = {
    val n = StdIn.readLine("What number will you choose? ").toInt
    val sums = ArrayBuffer[Int]()

    // n = 12
    val x = for (i ← 1 until n if n % i == 0) yield i
    // Another way of writing this out is the filter below
    // val y = (1 until n).filter(y ⇒ n % y == 0)

    // The following are one-liners for the entire function
    //    val z = (1 until n).filter(z ⇒ n % z == 0).map(z ⇒ n / z + z).min
    //    val b = (1 until n).collect { case b if n % b == 0 ⇒ n / b + b }.min
    //    val m = (1 until n).foldLeft {Int.MaxValue} { (p, x) ⇒
    //      if (n % x == 0 && x < p) n / x + x
    //      else p
    //    }
    //  eager vs lazy; eager inefficient for long sequences; when dealing with large collections, you will have to represent them in a lazy way somehow
    //  sometimes, you may have to use imperative style coding, e.g. using vars, as the finishing bit to a functional programming code

    for (i ← x) {
      val sum = (n / i) + i
      sums += sum
    }

    println(sums.min)
  }

// x: is used as x takes no arguments
  def repeat(x: ⇒ Unit): Unit = {
    while (StdIn.readLine("Do you to have another go? (Y/N) ") == "Y") x
  }

  findSmallestValueOfFactors()
  repeat(findSmallestValueOfFactors())


}
