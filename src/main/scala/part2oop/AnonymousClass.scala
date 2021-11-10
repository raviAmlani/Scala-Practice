package com.ravi.scalapractice
package part2oop

object AnonymousClass extends App {

  // We can instantiate Types and Override fields/methods instantly.
  // Works for Traits, Classes and Abstract Classes.
  // Implement all abstract fields/methods.

  trait AnomClass {
    def sum(a: Int, b: Int)
  }

  val anomClass: AnomClass = new AnomClass {
    override def sum(a: Int, b: Int) = println(a + b)
  }
  anomClass.sum(2, 98)
}
