package com.ravi.scalapractice
package part4patternmatching

import scala.collection.immutable.TreeSeqMap.Empty
import scala.runtime.Nothing$

object AllThePatterns extends App {

  // PatternMatching can be nested also.
  // NestedTuples
  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) => s"Hi, my value of v is $v"
  }
  println(matchNestedTuple)

  // List Patterns
  val aStdList = List(1, 2, 3, 50, 55, 60)
  val listMatching = aStdList match {

    // Below one is the Infix pattern - does the prepend operation before doing the comparison and save the
    // object with a name binding called "hello" which cna be used later in the Case or returning.
    // ::, +:, :+
    case hello @ 1 :: List(2, 3, 50, 55, 60) => println(hello)
    case List(1, tail @ _*) => println("Here is my tail - "+tail)

    // Extractor
    case List(0, _, _, _, _, _) => println("Now 2nd case")

    // Arbitrary Length Matching
    case List(1, _*) => println("Found the list with 1st item value 1")

    // Type specifier
    case list: List[Int] => println("List of Integer")

    // Multi-patterns
    case List(6, _*) | List(2, _*) => println("Multi-pattern matched.")

    // If guards
    case List(firstElement, _*) if firstElement == 1 => println("This List's first element is "+firstElement)

    // DEFAULT
    case _ => println("This is the default case")
  }

  // For-Comprehension, Catch block they all use Pattern Matching (Case) behind the scenes.
  // We can name the items in For-Comprehension too.
  val tuples = List((1,2), (3,4))
  val result = for {
    (first, second) <- tuples
  } yield first * second
  println(result)

  // Mutiple-Value-Definition is possible and it is based on Pattern Matching behind the scenes.
  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println("Hello b: "+b)

  val stdList2 = List(11,22,33)
  val head :: tail = stdList2
  println("Head: "+head)
  println("Tail: "+tail)

  // PARTIAL FUNCTION LITERAL (ADVANCED)
  // In a list.map {x => x match {} }, this can be re-written as...
  // list.map{ case, case, case }, this is called PFL.
}