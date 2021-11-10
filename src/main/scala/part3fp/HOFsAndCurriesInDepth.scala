package com.ravi.scalapractice
package part3fp

object HOFsAndCurriesInDepth extends App {

  // Function (nTimes) that applies a Function n times over a value of x.
  // nTimes(f, n, x)
  // nTimes(f, 3, x) = f(f(f(x))) = nTimes(f, 2, f(x))
  // nTimes(f, n, x) ==> nTimes(f, n-1, f(x))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n-1, f(x))
  }

  def plusOne1: Int => Int = (x: Int) => x + 1
  // OR
  def plusOne2 = (x: Int) => x + 1
  // OR
  def plusOne3: Int => Int = x => x + 1
  println(nTimes(plusOne1, 10, 0))

  // Better version whereby x on which function needs to be applied is not supplied with the regular list of params.
  // But supplied separately, one benefit of doing this way is we can keep the function ready and use it with any value we want.
  def nTimesBetter(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x
    else (x: Int) => nTimesBetter(f, n-1)(f(x))
  }

  val plusTen = nTimesBetter(plusOne1, 12)  // Your helper function is ready.
  println(plusTen(3))

  // CURRIED Function's - with Parameter and Return type mentioned.
  def curriedFunction: Int => (Int => Int) = (x: Int) => (y: Int) => x + y
  println(curriedFunction(5)(25))

  // Functions with Multiple Parameter Lists, again, this can be used to prepare the helper functions.
  def curriedFormatter(str: String)(d: Double): String = str.format(d)

  def helper1: Double => String = curriedFormatter("%4.2f") // We will supply the Double argument to curriedFormatter later through helper1 function.
  def helper2: Double => String = curriedFormatter("%4.8f") // same as above.
  println(helper1(Math.PI))
  println(helper2(Math.PI))

  // CURRIED FUNCTIONS - TAKING ANOTHER FUNCTION AS A PARAMETER
  def curryTakingAnotherFunction(f: (Int, Int) => Int): Int => Int => Int = {
    x => y => f(x, y)
  }
  println(curryTakingAnotherFunction(_ + _)(9)(10))

  // FUNCTION - TAKING CURRIED FUNCTION AS A PARAMETER
  def functionTakingCurry(f: (Int => Int => Int)): (Int, Int) => Int = {
    (x, y) => f(x)(y)
  }
  println(functionTakingCurry(curryTakingAnotherFunction(_ + _))(3, 7))

  // COMPOSE FUNCTION
  def compose[A, B, T](f: A => B, g: T => A): T => B =
    x => f(g(x))
  // AND-THEN FUNCTION
  def andThen[A, B, T](f: A => B, g: B => T): A => T =
    x => g(f(x))

  def plus2 = (x: Int) => x + 2
  def times3: Int => Int = x => x * 3

  val composed = compose(plus2, times3)
  val ordered = andThen(plus2, times3)

  println(composed(2))
  println(ordered(2))


}