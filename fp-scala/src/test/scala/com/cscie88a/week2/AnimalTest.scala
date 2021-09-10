package com.cscie88a.week2

import com.cscie88a.testutils.StandardTest

class AnimalTest extends StandardTest {
  "Animal" should {
    "singWithFriend1" in {
      val dog = Dog("puppy", "brown", "brown")
      val cat = Cat("kitty", "green", "brown")

      dog.singWithFriend(cat) shouldBe true
      cat.singWithFriend(dog) shouldBe false
    }
  }
}