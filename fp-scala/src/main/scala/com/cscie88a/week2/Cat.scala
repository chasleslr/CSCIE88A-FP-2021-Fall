package com.cscie88a.week2

final case class Cat(
    override val name: String,
    override val eyeColor: String,
    override val bodyColor: String
  ) extends Animal(name, eyeColor, bodyColor) with Trainable with Guard {
  
  override def takeMedicine(withTreat: Boolean): Boolean = {
    println("you cant trick me")
    false
  }

  override def doTrick(trickName: String): Boolean = {
    false
  }

  override def playWithToy(toy: Toy): Boolean = {
    if (toy.isSqueaky()) {
      println("Looks like a mouse... I'll play")
      toy.doFunStuff()
      true
    } else {
      println("don't feel like playing")
      false
    }
  }

  override def singWithFriend(aFriend: Animal): Boolean = {
    println("I won't do it")
    false
  }

  override def guardHome(): Boolean = {
    false
  }
}
