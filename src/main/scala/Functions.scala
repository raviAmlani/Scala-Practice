package com.ravi.scalapractice

object Functions extends App {

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
}
