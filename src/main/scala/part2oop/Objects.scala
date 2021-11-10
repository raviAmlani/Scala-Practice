package com.ravi.scalapractice
package part2oop

object Objects {

  // SCALA DOESN'T HAVE CLASS LEVEL FUNCTIONALITIES I.E. STATIC VARS, METHODS ETC.
  // INSTEAD, IT OFFERS OBJECTS.
  // They are SINGLETON by definition, no instantiation required.

  object Person { // this is type + singleton instance
    // CLASS LEVEL FUNCTIONALITY
    val N_EYES = 2  // this is equivalent to the constants (static) we defined in Java.
    def canFly(): Boolean = false

    // Factory Pattern, you can set any name to this method, but setting the name apply() means
    // it can be accessed without giving a method name, hence it looks like a constructor.
    def apply(name: String, age: Int = 0): Person = new Person(name)
  }

  // Either extend the App class which contains below main() or define main() here and write the code inside it.
  def main(args: Array[String]): Unit = {

    // ------- Accessing Object-----------
    val Mary = Person
    val John = Person
    println(Mary.N_EYES + " " +Mary.canFly())
    println("Are Mary and John same instances: "+ (Mary == John))

    // ------- Accessing Class-----------
    val lewis = new Person("Lewis")
    val max = new Person("Max")
    lewis.greeting()
    println(lewis == max)

    // Construct an instance using Factory Method
    val lando = Person("Lando") // Calling apply() method without specifying it's name.
    lando.greeting()
    println(lando == lewis)

  }

  // Having a CLASS AND OBJECT of the same name in the same file is called COMPANIONS.
  // Companions can access each other's private members.
  class Person(name: String) {
    // INSTANCE LEVEL FUNCTIONALITY
    def greeting() = println(s"Hello, my name is $name");
  }

  // Access Modifiers:
  // public is default
  // private
  // protected - only subclass can inherit the protected members.

  // Prevent a class/member from being extended by using "final" keyword.

  // "Sealed" keyword can be used with a class if you want that class to be extended only in the same file but not outside of that file.

  // Member can be overridden in Scala using "override", ex. override val name = "";
  // Class field can also be overridden directly by using "override" keyword in a child class definition,
  // without any need of defining a val inside the class.

}
