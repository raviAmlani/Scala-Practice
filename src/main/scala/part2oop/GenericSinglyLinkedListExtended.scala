package com.ravi.scalapractice
package part2oop

import java.util
import java.util.NoSuchElementException
import scala.runtime.Nothing$

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

    def filter(myPredicate: MyPredicate[A]): MyGenericList[A]
    def map[B](transformer: MyTransformer[A, B]): MyGenericList[B]
    def flapMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B]

    def ++[B >: A](list: MyGenericList[B]): MyGenericList[B]

  }

  case object EmptyGenericList extends MyGenericList[Nothing] {

    override def head: Nothing = throw new NoSuchElementException
    override def tail: Nothing = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def add[B >: Nothing](element: B): MyGenericList[B] = new ConsGeneric(element, EmptyGenericList)

    override def printElements(): String = ""

    def filter(myPredicate: MyPredicate[Nothing]): MyGenericList[Nothing] = EmptyGenericList
    def map[B](transformer: MyTransformer[Nothing, B]): MyGenericList[B] = EmptyGenericList

    def ++[B >: Nothing](myList: MyGenericList[B]): MyGenericList[B] = myList
    def flapMap[B](transformer: MyTransformer[Nothing, MyGenericList[B]]): MyGenericList[B] = EmptyGenericList

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

    def filter(myPredicate: MyPredicate[A]): MyGenericList[A] = {
      if (myPredicate.test(head)) new ConsGeneric(head, tail.filter(myPredicate))
      else tail.filter(myPredicate)
    }
    def map[B](transformer: MyTransformer[A, B]): MyGenericList[B] = {
      new ConsGeneric(transformer.transform(head), tail.map(transformer))
    }

    def ++[B >: A](myList: MyGenericList[B]): MyGenericList[B] = {
      new ConsGeneric[B](head, tail ++ myList)
    }
    def flapMap[B](transformer: MyTransformer[A, MyGenericList[B]]): MyGenericList[B] = {
      transformer.transform(head) ++ tail.flapMap(transformer)
    }

  }

  trait MyPredicate[-T] {
    def test(element: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(element: A): B
  }

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
    println(singlyLinkedList12.map(new MyTransformer[Int, Int] {
      override def transform(element: Int): Int = element * 2
    }).toString)

    println(singlyLinkedList13.filter(new MyPredicate[Int] {
      override def test(element: Int): Boolean = element % 3 == 0
    }).toString)

    println("----------------")
    println(singlyLinkedList12 ++ singlyLinkedList13)
    println(singlyLinkedList13.flapMap(new MyTransformer[Int, MyGenericList[Int]] {
      override def transform(element: Int): MyGenericList[Int] = new ConsGeneric(element, new ConsGeneric(element+1, EmptyGenericList))
    }).toString)

  }
