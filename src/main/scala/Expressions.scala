package com.ravi.scalapractice

object Expressions extends App {

  // IF in Scala is an expression which returns a value.

  val boolVal = true
  println("Output: " + (if(boolVal) 5 else 3))

  // Variables, reassignments, while loops, println() are SIDE-EFFECTS in Scala
  // Side-effects returns Unit in Scala.
  // Unit is equivalent to NULL, and it's value is "()"

  var aVar = 6
  val aWeirdVal = (aVar = 3) // returns UNIT
  println(aWeirdVal)

  // CODE-BLOCKS in Scala returns the value of the last expression

  val block1 = {
    2 < 3   // No need of IF condition
  }
  println("block1: "+block1)

  val block2 = {
    if (block1) 11 else 22
    99
  }
  println("block2: " +block2)

}
