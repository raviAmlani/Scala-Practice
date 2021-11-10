package com.ravi.scalapractice

object StringOperations extends App {

  // Scala has access  to Java's String class so all the String methods are accessible here too.

  // Scala Specifics:

  // Append and Prepend Operations.
  val str: String = "2"
  println(str  +: "H")
  println(str :+ 'H')
  println('a' +: str :+ 'z')

  // String (S) Interpolators
  val name = "Alpha"
  val age = 99
  val interpolatedStr = s"Hello, my name is $name and I am $age years old"
  val interpolatedStrWithExpression = s"Hello, my name is $name and I am ${age + 1} years old"
  println(interpolatedStr)
  println(interpolatedStrWithExpression)

  // F Interpolators -> for formatting the String
  val nameInInt = 100
  val speed = 1.2f
  println(f"Hello, my name is $nameInInt%s and I can eat burgers at the speed of $speed%2.2f per minute")
    // %s does the String representation, and %2.2f makes sure to print 2 int and 2 decimal points.

  // Raw Interpolators - prints the String as is
  // starts with "raw"
  println(raw"Hello, my name is $nameInInt%s and I can eat burgers at the speed of $speed%2.2f per minute")
}
