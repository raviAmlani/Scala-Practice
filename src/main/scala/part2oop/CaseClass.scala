package com.ravi.scalapractice
package part2oop

object CaseClass extends App {

  case class Person(name: String, age: Int) {
  }
  val kimi = new Person("Kimi", 35)

  // 1. Case Classes automatically get Fields out of the Parameters.
  println(kimi.age)

  // 2. toString is formatted sensibly.
  println(kimi.toString)

  // 3. Have companion objects.
  var george = Person
  var daniel = Person("Daniel", 40)
  println(george)

  // 4. copy method is handy - copies an object.
  var checo = kimi.copy()
  println(checo)

  // 5. equals and hashcode methods are already implemented.
  println(kimi == checo)
  println(kimi.hashCode())
  println(checo.hashCode())

  // 6. They are serializable --> Akka

  // 7. They have extractor pattern --> they are used in PATTERN MATCHING

  // 8. Just like Case Classes, there can be Case Objects also.
  // They don't get companion objects.
  case object Person {
    def test: String = "Hello, I am a Case Object!"
  }
}
