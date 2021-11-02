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

  abstract class MyList {
    def head: Int
    def tail: MyList
    def isEmpty: Boolean
    def add(element: Int): MyList

    def printElements(): String
    override def toString: String = "["+ printElements +"]"
  }

  object EmptyList extends MyList {

    override def head: Int = throw new NoSuchElementException
    override def tail: MyList = throw new NoSuchElementException
    override def isEmpty: Boolean = true
    override def add(element: Int): MyList = new Cons(element, EmptyList)

    override def printElements(): String = ""
  }

  class Cons(h: Int, t: MyList) extends MyList {

    override def head: Int = h
    override def tail: MyList =  t
    override def isEmpty: Boolean = false
    override def add(element: Int): MyList = new Cons(element, this)

    override def printElements(): String = {
      if (tail.isEmpty) "" + head
      else head  + " " + tail.printElements()
    }
  }

  object ListTest extends App {
    val singlyLinkedList1 = new Cons(1, EmptyList)
    println(singlyLinkedList1.head);
    println(singlyLinkedList1.tail)
    println("----")
    val singlyLinkedList12 = singlyLinkedList1.add(2)
    println(singlyLinkedList12.head);
    println(singlyLinkedList12.tail.head);
    println(singlyLinkedList12.tail)

    println("----------------")
    val singlyLinkedList2 = new Cons(1, new Cons(2, new Cons(3, EmptyList)))
    println(singlyLinkedList2.head);
    println(singlyLinkedList2.tail)
    println(singlyLinkedList2.tail.head);
    println(singlyLinkedList2.tail.tail.head);

    println("----")
    println(singlyLinkedList1.toString);
    println(singlyLinkedList2.toString);
  }
