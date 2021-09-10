package com.cscie88a.week2

class Animal(
  val name: String,
  val eyeColor: String,
  val bodyColor: String
  ) {
  def takeMedicine(withTreat: Boolean): Boolean =
    if (withTreat) true else false

  def playWithToy(toy: Toy): Boolean = {
    println(s"I've got a toy: ${toy.name}!")
    true
  }
}
