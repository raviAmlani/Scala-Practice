package com.ravi.scalapractice
package part3fp

import java.util.NoSuchElementException

  // Abstract class vs. Traits (similar to Interfaces in Java)
  // They both can contains Abstract as well as non-abstract members.
  // Only one class can be 'extended' but multiple traits can be extended (using "with" keyword)
  // Traits describe what they do.

  // All classes in Scala derive from AnyRef (which is mapped to the Object class in Java)
  // And AnyRef derives from Any, which is a most super type in Scala.
  // Scala.Null derives from AnyRef. Null can replace any class type.
  // All the Premitive types inherit from a type called AnyVal (rarely used)
  // Scala.Nothing inherit from Scala.AnyVal and Scala.Null, so it can replace basically anything.

/**
 * This class implements the Function-Types and High Order Functions.
 *
 * Either comment this class or GenericSinglyLinkedListExtended in order to run any of them.
 * They both share the same class names.
 */

abstract class MyGenericList[+A] {
    def head: A
    def tail: MyGenericList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyGenericList[B]

    def printElements(): String
    override def toString: String = "["+ printElements +"]"

    def map[B](transformer: A => B): MyGenericList[B]
    def flapMap[B](transformer: A => MyGenericList[B]): MyGenericList[B]
    def filter(myPredicate: A => Boolean): MyGenericList[A]

    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]

  }

  case object EmptyGenericList extends MyGenericList[Nothing] {

    override def head: Nothing = throw new NoSuchElementException
    override def tail: Nothing = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def add[B >: Nothing](element: B): MyGenericList[B] = new ConsGeneric(element, EmptyGenericList)

    override def printElements(): String = ""

    def filter(myPredicate: Nothing => Boolean): MyGenericList[Nothing] = EmptyGenericList
    def map[B](transformer: Nothing => B): MyGenericList[B] = EmptyGenericList

    def ++[B >: Nothing](myList: MyGenericList[B]): MyGenericList[B] = myList
    def flapMap[B](transformer: Nothing => MyGenericList[B]): MyGenericList[B] = EmptyGenericList

  }

  case class ConsGeneric[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {

    override def head: A = h
    override def tail: MyGenericList[A] =  t
    override def isEmpty: Boolean = false
    override def add[B >: A](element: B): MyGenericList[B] =  new ConsGeneric(element, this)

    override def printElements(): String = {
      if (tail.isEmpty) "" + head
      else head  + " " + tail.printElements()
    }

    def filter(myPredicate: A => Boolean): MyGenericList[A] = {
      if (myPredicate(head)) new ConsGeneric(head, tail.filter(myPredicate))
      else tail.filter(myPredicate)
    }
    def map[B](transformer: A => B): MyGenericList[B] = {
      new ConsGeneric(transformer(head), tail.map(transformer))
    }

    def ++[B >: A](myList: MyGenericList[B]): MyGenericList[B] = {
      new ConsGeneric[B](head, tail ++ myList)
    }
    def flapMap[B](transformer: A => MyGenericList[B]): MyGenericList[B] = {
      transformer (head) ++ tail.flapMap(transformer)
    }

  }

  // Replacing below Traits with Function-Types.
  /*trait MyPredicate[-T] {
    def test(element: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(element: A): B
  }*/

  object GenericListTest extends App {
    val singlyLinkedList1: MyGenericList[Int] = new ConsGeneric(1, EmptyGenericList)
    println(singlyLinkedList1.head);
    println(singlyLinkedList1.tail)
    println("----")
    val singlyLinkedList12 = singlyLinkedList1.add(2)
    println(singlyLinkedList12.head);
    println(singlyLinkedList12.tail.head);
    println(singlyLinkedList12.tail)
    val singlyLinkedList13 = singlyLinkedList12.add(2).add(3).add(4)

    println("----------------")
    val singlyLinkedList2: MyGenericList[String] = new ConsGeneric("Hello", new ConsGeneric("World", new ConsGeneric("Scala", EmptyGenericList)))
    println(singlyLinkedList2.head);
    println(singlyLinkedList2.tail)
    println(singlyLinkedList2.tail.head);
    println(singlyLinkedList2.tail.tail.head);

    println("----")
    println(singlyLinkedList1.toString);
    println(singlyLinkedList12.toString);
    println(singlyLinkedList13.toString)
    println(singlyLinkedList2.toString)

    println("----------------")
    println(singlyLinkedList12.map(new Function1[Int, Int] {
      override def apply(element: Int): Int = element * 2
    }).toString)

    println(singlyLinkedList13.filter(new Function1[Int, Boolean] {
      override def apply(element: Int): Boolean = element % 3 == 0
    }).toString)

    println("----------------")
    println(singlyLinkedList12 ++ singlyLinkedList13)
    println(singlyLinkedList13.flapMap(new Function1[Int, MyGenericList[Int]] {
      override def apply(element: Int): MyGenericList[Int] = new ConsGeneric(element, new ConsGeneric(element+1, EmptyGenericList))
    }).toString)

  }