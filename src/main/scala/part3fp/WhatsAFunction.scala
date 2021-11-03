package com.ravi.scalapractice
package part3fp

object WhatsAFunction extends App {

  // If Interface or Abstract class has only one method, in Scala it is normal to name it apply() so that
  // when we create an anonymous class/method body it can be directly called.
  // Below example is one step ahead, instead of creating an anonymous class, it demonstrates the built-in Function Type.

  // There are 22 Function classes Scala supports.

  val strConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }

  println(strConcatenator("Lewis", "Hamilton"))   // doesn't need to call apply()

  // Now the same function type can be represented as ((String, String) => String)
  // First 2 as param types, and 3rd as a return type.
  // Check the syntax below.

  val strConcatenator2: ((String, String) => String) = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + " " + v2
  }

  val masterAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(v1: Int): Function1[Int, Int] = new Function1[Int, Int]{
      override def apply(v2: Int): Int = {
        v1 + v2
      }
    }
  }

  val adder = masterAdder(3)
  println(adder(3))
  println(masterAdder(5)(6))  // Curried Function

}
