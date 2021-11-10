package com.ravi.scalapractice
package part3fp

object AnonymousFunctions extends App {

  val doubler = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  // Above function can be re-written by omitting Function1 definition.
  // THIS IS CALLED LAMBDA
  val doubler2 = (a: Int) => a * 2
  println(doubler2(2))

  // Now if we define the Param type and Return type with a val itself then the (v1: Int) can be omitted.
  val doubler3: Int => Int = a => a * 2
  println(doubler3(3))

  // 2 Parameter Function.
  val adder1 = (a: Int, b: Int) => a + b
  println(adder1(2,3))

  // 2 Param Function with Types specified - when more than 1 params then brackets are mandatory.
  val adder2: (Int,Int) => Int = (a, b) => a + b
  println(adder2(100,101))

  // 0 Param Function
  val zeroParam1 = () => 3
  val zeroParam2: () => Int = () => 4
  println(zeroParam1())
  println(zeroParam2())

  // Curly braces with Lambda.
  val strToInt = { (str: String) =>
    str.toInt
  }
  println(strToInt("123"))

  // Underscore (_) Syntax
  // When we define the Param type and return type, we can omit the param names as well on the right hand side.
  val anotherAdder: (Int, Int) => Int = _ + _
  println(anotherAdder(9, 9))

  // LAMBDA way of calling Function -> Function -> Return type. (Just like masterAdder inside WhatsAFunction Object)
  val masterAdder = (a: Int) => (b: Int) => a + b
  println(masterAdder(2)(9))

  // val whatsAFunction = WhatsAFunction
  // println(whatsAFunction.masterAdder(12))

}