package com.ravi.scalapractice
package part3fp

import scala.util.{Success, Try}

object HandlingFailures extends App {

  // TRY is an abstract class being extended by Success and Failure classes.
  // Success and Failure will wrap the succeeded and failed computations respectively.

  val aSuccess = Success(3)
  def unsafeMethod(): String = throw new RuntimeException("TEST-123")
  val potentialFailure = Try(unsafeMethod())

  println(aSuccess)
  println(potentialFailure)
  println("Continue...")    // Program didn't crash.

  // Syntax Sugar.
  val anotherPotentialFailure = Try {   // T capital (calls apply() method) as opposed to 'try'
    unsafeMethod()
  }
  println(anotherPotentialFailure)

  // Just like Option, orElse can be used in the same way.

  // Methods like map, flatMap, filter (or for-comprehension) are ways to utilize Try and Option.

}