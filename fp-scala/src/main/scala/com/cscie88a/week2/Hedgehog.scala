package com.cscie88a.week2

case class Hedgehog(
  override val name: String,
  override val eyeColor: String,
  override val bodyColor: String
) extends Animal(name, eyeColor, bodyColor) with Trainable with Guard {
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

  override def doTrick(trickName: String): Boolean = {
    false
  }

  override def singWithFriend(aFriend: Animal): Boolean = {
    println("I might do it since I'm curious.")
    if (scala.util.Random.nextBoolean()) {
      true
    } else {
      println("Hmm. Not this time.")
      false
    }
  }

  override def guardHome(): Boolean = {
    false
  }
}