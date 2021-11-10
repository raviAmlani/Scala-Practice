package com.ravi.scalapractice
package part2oop

object Generics extends App {

  // Type-Parameter
  class MyList[A]
  val intList: MyList[Int] = new MyList[Int]
  val strList = new MyList[String]

  object MyList { // Object can't receive type-parameters
    def emptyList[A]: MyList[A] = ???
  }
  val emptyIntList = MyList.emptyList[Int]

  // Variance Problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Covariance // Adding any animals to the list - Hard question ==> we return the list of Animals instead of Cats or Dogs.
  // Check example at line 40.
  class CovariantList[+A]
  val covariantAnimalList: CovariantList[Animal] = new CovariantList[Cat]

  // Invariance // Adding the same type
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // Contravariance // Not desired.
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // Bounded Types - Upper Bounded (Lower Bounded >:)
  class Cage[A <: Animal](animal: A)
  val cage = new Cage(new Cat())
  // same:
  // val cage = new Cage[Cat](new Cat())

  class MyAnimalsList[+A] {
    def add[B >: A](element: B): MyAnimalsList[B] = ???
    // A = Cat, B = Animal
  }

}
