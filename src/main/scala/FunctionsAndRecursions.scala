package com.ravi.scalapractice

import scala.annotation.tailrec

object FunctionsAndRecursions extends App {

  def function1(a: String, b: Int): String =  // parenthesis are optional
    a + " <-> " + b

  println(function1("Hello", 24))

  def functionWithParenthesis(a: String, b: Int): String = {
    a
  }
  println(functionWithParenthesis("functionWithParenthesis", 99))

  // Functions without any params can be called with or without parenthesis

  def functionWithNoParams(): Int =
    6

  println(functionWithNoParams())
  println(functionWithNoParams)

  functionWithNoParams

  def factorialFunction(a: Int): Int = {
    if (a <= 0) 1
    else a * factorialFunction(a - 1)
  }

  // =============================================

  println("Factorial: "+factorialFunction(6))

  def isPrime(a: Int): Boolean = {
    // Auxiliary Function - function inside function
    def isPrimeUntil(t: Int): Boolean = {
     if (t <= 1) true
     else {
        // if (a % t != 0) println("TRUE") else println("FALSE")
        a % t != 0 && isPrimeUntil(t - 1)
     }
    }

    isPrimeUntil(a/2)
  }

  print("Is Prime Number: "+isPrime(37))

  // RECURSION

  // TAIL-RECURSION
  // Any function can be turned into TailRecursive function by using an Accumulator parameter(s) to store the intermediate results.
  // Additionally, you can also use @tailrec annotation above the (Aux) method
  // When you need loops, use tailRec function.
  // RULES OF THUMB
  // Recursion must be the last expression of the code block in order to make it TailRecursive.
  // Accumulator should have the same return type as the final return type of the function.
  // Number of Accumulators should be same as number of times you are going to call the function.

  @tailrec
  def tailRecConcatenate(str: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else tailRecConcatenate(str, n-1, accumulator + str)
  }
  println("tailRecConcatenate: "+tailRecConcatenate("Hello.", 3, ""))

  def isPrime2(a: Int): Boolean = {
    @tailrec  // not a mandatory annotation, but compiler will throw an error if below function is not called as tailRec.
    def isPrime2Until(t: Int, accumulator: Boolean): Boolean = {
      if (t <= 1) true
      else if (!accumulator) false // no point of checking further if n itself or n/2 or any furthter number is divisive.
      else
        isPrime2Until(t-1, a % t != 0 && accumulator)
    }

    isPrime2Until(a/2, true)
  }

  println(isPrime2(2003))

  // Default Arguments - can be given to the function but either they all should be default or the trailing ones only.
  // Leading default and trailing not default - compiler gets confused while sending the params.
  // In such case, pass the params with name. Also, when passing the params, sequence of params don't matter.

  @tailrec
  def tailRecFactorialDefaultArg(n: Int, accumulator: Int = 1): Int = {
    if (n <= 1) accumulator
    else tailRecFactorialDefaultArg(n-1, n * accumulator)
  }

  println("-------------------------")
  println("Factorial: "+tailRecFactorialDefaultArg(5))  // if "n" had a default value and "accumulator" hadn't then this type of call would show an error.
  println("Factorial: "+tailRecFactorialDefaultArg(6, 1))
  println("Factorial: "+tailRecFactorialDefaultArg(accumulator = 1, n = 7))



}
