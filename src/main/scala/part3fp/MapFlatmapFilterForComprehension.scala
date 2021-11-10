package com.ravi.scalapractice
package part3fp

object MapFlatmapFilterForComprehension extends App {

  val list1 = List(1, 2, 3)
  println(list1)
  println(list1.head)
  println(list1.tail)

  // map
  println(list1.map(_ + " is a num"))

  // filter
  println(list1.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list1.flatMap(toPair))

  // foreach
  list1.foreach(println)

  // Print all combination between 3 lists.
  // Non-functional programming we would take 2 loops or 3 loops based on number of lists we have.
  // In Functional programming, we can replace them with flatMap functions with last one being a Map one.
  val nums = List(1, 2, 3)
  val chars = List("a", "b", "c")
  val colors = List("Blue", "Black")

  val combinations = nums.flatMap(n => chars.flatMap(c => colors.map(color => n + "-" + c + "-" + color)))
  println(combinations)

  // For Comprehensions - For better readability
  val forComprehension = for {
    n <- nums if (n % 2 == 0) // Yes, conditions are allowed, this is equivalent to the nums.filter() before nums.flatMap.
    c <- chars
    color <- colors
  } yield n + "-" + c + "-" + color
  println(forComprehension)

}