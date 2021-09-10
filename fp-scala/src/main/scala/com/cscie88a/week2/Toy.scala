package com.cscie88a.week2

case class Toy(
  name: String,
  squeaky: Boolean
) {
  def doFunStuff() =
    println(s"I am playing with my fun toy: ${name}")

  def isSqueaky(): Boolean =
    if (squeaky) true else false
}