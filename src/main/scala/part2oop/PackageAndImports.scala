package com.ravi.scalapractice
package part2oop

// import for IronMan
// "import playground.IronMan"

// Group Imports
// import playground.{IronMan, Thor}

// You can alias a class name
import playground.{IronMan, Thor => StrongThor}

// For importing all from the package, instead of * Scala uses Underscore.
import playground._

object PackageAndImports extends App {

  // Using Methods and Constants from the Package Object, without any prefix or imports.
  println(sum(33, 33))
  println(SPEED_OF_LIGHT)

  // No imports needed, class is part of a parent package.
  CallByNameAndValue.callByValue(12)

  // Imports needed for below classes as they are in a diff package.
  val ironMan = new IronMan
  var thor = new StrongThor // due to aliasing. See the import.


}
