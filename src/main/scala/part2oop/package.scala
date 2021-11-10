package com.ravi.scalapractice

package object part2oop {

  // Created as right click on a package --> create "Package Object"
  // Each package can have only one package object.
  // It can contain Methods and Constants which we want to be accessible through entire package.

  def sum(a: Int, b: Int) = a + b

  val SPEED_OF_LIGHT = 299792458

}
