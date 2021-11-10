package com.ravi.scalapractice
package part2oop

import org.w3c.dom.css.Counter

import scala.language.postfixOps

object OOBasics extends App {

  val smallestClass = new SmallestClass
  smallestClass.toString

  val person = new Person("Lewis", 24)
  println(person.x)
  // name and age are the Class PARAMS, not the FIELDS hence they cannot be accessed outside the class.
  // In order to do so, put "val" before that.
  println(person.age)
  person.greeting("Max")
  person.greeting()

  val personConstructor2 = new Person("Lando")
  personConstructor2.greeting()

  val personConstructor3 = new Person()
  personConstructor3.greeting()

  // =======================

  val counter = new Counter()
  counter.print
  counter.inc().print
  counter.inc().print
  counter.inc(10).dec(5).inc().print
  counter.dec(5).print

  // METHODS WITH EXACTLY ONE PARAM CAN BE CALLED LIKE NATURAL LANGUAGE
  // IT IS CALLED INFIX NOTATION = OPERATOR NOTATION (SYNTACTIC SUGAR)
  // mary likes tom
  // Suppose mary and tom both are Person's objects. And "likes" is a method accepting an object of a Person class.
  counter inc 10

  // You can set method names as +, -, ! etc. in Scala.

  // Prefix Notation unary_ works with + - ~ ! operators.
  // unary_! etc. which will be treated as operators are overloaded.
  // ex.
  val y = 1.unary_- // this is equivalent to the previous line.
  val x = -1

  // Postfix notation - works with the methods with no parameters. Only difference is dot(.) is being replaced by a space.
  println(person.isAlive)
  // is same as...
  println(person isAlive)

  // "apply"
  // When compiler sees that an object is being called like a function, it looks for an apply() method.
  // Hence both the below statements do the same thing.
  println(person.apply)
  println(person())

}

  class SmallestClass  // Smallest form of a class

  class Person(name: String, val age: Int) {
    // Body
    val x = 2

    // Method
    def greeting(name: String) = {
      println(s"Hello $name, says $name")
      // In order to use the "name" field of the class (method sharing the same name), "this" needs to be used
      // BUT if this method haven't had any params then use of "this" wouldn't be needed at all. See the overloaded method below.
      println(s"Hello $name, says ${this.name}")
    }

    // Method overloading
    def greeting() = {
      println(s"Hello $name, says ${this.name}")
    }

    // Multiple Constructors
    // The implementation of the Constructors can only consist of a call to another constructor, due to this down-side,
    // defining the primary constructor with default values makes more sense.
    def this(name: String) = this(name, 0)  // on the right hand side, it is a call to the Primary constructor defined along with class Person(...){...}
    def this() = this("Some name")

    // Posfix notation
    def isAlive() : Boolean = true

    // "apply"
    def apply() : String = s"Hi, my name is $name and my age is $age"
  }

  // COUNTER CLASS
  // OBJECTS ARE IMMUTABLE IN SCALA, SCALA WILL RETURN A NEW OBJECT IF THE CONTENT CHANGES.

  class Counter(val n: Int = 0) {
    def inc(): Counter = {
      new Counter(n+1)
    }

    def dec() = {
      new Counter(n-1)
    }

    def inc(amount: Int): Counter = {
      if (amount <= 0) this
      else inc().inc(amount-1)
    }

    def dec(amount: Int): Counter = {
      if (amount <= 0) this
      else dec().dec(amount-1)
    }

    def print = println("Counter Value: "+n)

  }
