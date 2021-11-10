package com.ravi.scalapractice
package part3fp

object TuplesAndMaps extends App {

  // Examples can be found from Daniel's repo.
  // https://github.com/rockthejvm/udemy-scala-beginners/blob/master/src/main/scala/lectures/part3fp/TuplesAndMaps.scala

  val aMap: Map[String, Int] = Map()
  val phoneBook = Map[String, Int](("Ravi", 123), "Sean" -> 456).withDefaultValue(-1)
  println(phoneBook)

  println(phoneBook.contains("Stranger"))
  println(phoneBook.get("Ravi"))    // output not understood.
  println(phoneBook("Ravi"))    // Equivalent to get function in Java

  val updatedPhoneBook = phoneBook + ("Jahziel" -> 789)
  println(updatedPhoneBook)

  // FUNCTIONALS
  // map, filter, flatMap ==> They all take pair as a parameter when used with Map.
  val phoneBookLowerCase = phoneBook.map(pair => pair._1.toUpperCase() -> pair._2)
  println(phoneBookLowerCase)

  // filterKeys()
  println(phoneBook.view.filterKeys(name => name.startsWith("R")).toMap)

  // mapValues()
  println(phoneBook.view.mapValues(value => "+353 "+value).toMap)

  // Conversion to other Collections.
  println(phoneBook.toList)
  println(List(("Hello" -> "World"), ("test", "test")).toMap)

  // GroupBy ==> Produces the map with key being a letter and value being a list of Strings.
  val nameList = List("Lewis", "Max", "Lando", "George", "Sergio", "Something with s")
  val nameMap = nameList.groupBy(name => name.charAt(0))
  println(nameMap)
  println((nameList.groupBy(name => name.charAt(0))('L')))

  // Suppose there is a Map[String, Set[String] --> Let's call it "network" then some examples of operations on it.
  // Find an item with max number of items in Set.
  // Returns a key ===> network.maxBy(pair => pair._2.size)._1

  // Find number of items with 0 items in Set
  // network.filterKeys(k => k.size == 0).size
  // All of the below format are similar...
  // network.filter(pair => pair._2.size == 0).size
  // network.filter(pair => pair._2.isEmpty).size
  // network.count(pair => pair._2.isEmpty) // REPLACING FILTER AND SIZE BY COUNT.
  // network.count(_.2_isEmpty)


}