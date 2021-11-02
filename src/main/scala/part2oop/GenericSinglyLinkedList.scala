package com.ravi.scalapractice
package part2oop

import java.util
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

  abstract class MyGenericList[+A] {
    def head: A
    def tail: MyGenericList[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyGenericList[B]

    def printElements(): String
    override def toString: String = "["+ printElements +"]"
  }

  object EmptyGenericList extends MyGenericList[Nothing] {

    override def head: Nothing = throw new NoSuchElementException
    override def tail: Nothing = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def add[B >: Nothing](element: B): MyGenericList[B] = new ConsGeneric(element, EmptyGenericList)

    override def printElements(): String = ""
  }

  class ConsGeneric[+A](h: A, t: MyGenericList[A]) extends MyGenericList[A] {

    override def head: A = h
    override def tail: MyGenericList[A] =  t
    override def isEmpty: Boolean = false
    override def add[B >: A](element: B): MyGenericList[B] =  new ConsGeneric(element, this)

    override def printElements(): String = {
      if (tail.isEmpty) "" + head
      else head  + " " + tail.printElements()
    }
  }

  object ListTest extends App {
    val singlyLinkedList1: MyGenericList[Int] = new ConsGeneric(1, EmptyGenericList)
    println(singlyLinkedList1.head);
    println(singlyLinkedList1.tail)
    println("----")
    val singlyLinkedList12 = singlyLinkedList1.add(2)
    println(singlyLinkedList12.head);
    println(singlyLinkedList12.tail.head);
    println(singlyLinkedList12.tail)

    println("----------------")
    val singlyLinkedList2: MyGenericList[String] = new ConsGeneric("Hello", new ConsGeneric("World", new ConsGeneric("Scala", EmptyGenericList)))
    println(singlyLinkedList2.head);
    println(singlyLinkedList2.tail)
    println(singlyLinkedList2.tail.head);
    println(singlyLinkedList2.tail.tail.head);

    println("----")
    println(singlyLinkedList1.toString);
    println(singlyLinkedList2.toString);
  }
