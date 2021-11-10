package com.ravi.scalapractice
package part4patternmatching

object PatternMatching extends App {

  // Allows us to match with an Instance also, also allows us to guard with if conditions.
  // Matched in order
  // If no cases match then returns MatchError
  // If no types match then it returns unified type of all the cases.

  case class Person(name: String, age: Int)

  val lewis = Person("Lewis", 35)

  val greeting = lewis match {
    case Person(n, a) if a > 34 => s"My name is $n and I am above 34"
    case Person(n, a) => s"My name is $n"
    case _ => "I don't know my name"
  }
  println(greeting)


}