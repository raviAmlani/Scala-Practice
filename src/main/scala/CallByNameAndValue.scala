package com.ravi.scalapractice

object CallByNameAndValue extends App {

  def callByValue(x: Long) = {
    println("By Value: " +x)
    println("By Value: " +x)
  }

  // CALL BY NAME (REFERENCE) LITERALLY PRINTS THE EXPRESSION "System.nanoTime()" AT x'S PLACE.
  // => IS USED TO ASSIGN WITH CALL BY NAME.
  def callByName(x: => Long): Unit = {
    println("By Name: "+x)
    println("By Name: "+x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

}
