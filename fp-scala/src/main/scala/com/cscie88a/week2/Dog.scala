package com.cscie88a.week2

final case class Dog(
  override val name: String,
  override val eyeColor: String,
  override val bodyColor: String
  ) extends Animal(name, eyeColor, bodyColor)
       with Trainable with Guard {

  override def doTrick(trickName: String): Boolean = {
    println(
      s"${name} says - dogs love doing tricks. I'm doing a trick ${trickName} now"
    )
    true
  }

  override def playWithToy(toy: Toy): Boolean = {
    println("I love the toy! Yeah!!!")
    toy.doFunStuff()
    true
  }

  override def singWithFriend(aFriend: Animal): Boolean = {
    println(s"I am singing with my friend ${aFriend.name}")
    true
  }

  override def guardHome(): Boolean = {
    true
  }
}
