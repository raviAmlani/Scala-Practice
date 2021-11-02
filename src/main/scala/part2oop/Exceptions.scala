package com.ravi.scalapractice
package part2oop

object Exceptions extends  App {

  // val anExceptionVal: NullPointerException = throw new NullPointerException
  // Throwing returns Nothing.

  def getInt (bool: Boolean): Int = {
    if (bool) throw new RuntimeException
    else 66
  }

  try {
    getInt(true)
  } catch {
    case e: RuntimeException => println("Caught a Runtime Exception")
  } finally {
    println("Finally! This gets executed no matter what!")
  }
}
