package com.ravi.scalapractice

object Variables extends App {

  print("--- Values (IMMUTABLE) ---")
  // VALS are IMMUTABLE

  val x: Int = 24
  println("value of x: " +x);
  val z: Int = x
  println("z: "+z)

  val y = 25; // Compilers can infer types.
  println("y: "+y)

  val testShort: Short = 1234
  val testLong: Long = 12345678

  val testStr: String = "Hello"
  val testChar: Char = 'a'

  val testFloat: Float = 123.4f
  val testDouble: Double = 1234.5678


  println("--- Variables (MUTABLE) ---")
  // VARIABLES - MUTABLE

  var a: Int = 21
  println("a: "+a)
  a += a
  println("a: "+a)
  var b = 4
  b = a
  println("b: "+b)

}
