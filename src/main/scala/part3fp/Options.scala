package com.ravi.scalapractice
package part3fp

object Options extends App {

  val myFirstOption: Option[Int] = Some(4)
  val mySecondOption: Option[Int] = None

  // Options are built with Some or None.

  def unsafeMethod(): Option[String] = None
  def backupMethod(): Option[String] = Some("I am your backup")
  val chainedResult = unsafeMethod().orElse(backupMethod())

  // filter() method will return either Some or None (if predicate is not matching), same for the map() as well.
  // flatMap() can be used to convert value to Option which will eventually return Some.



}