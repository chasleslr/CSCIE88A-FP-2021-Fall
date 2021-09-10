package com.cscie88a.week2

import com.cscie88a.testutils.StandardTest

class DogTest extends StandardTest {

  "Dog" should {
    val dog1 = Dog("fido", "brown", "black")
    val toy = Toy("Ball", false)

    "take medicine with treat" in {
      dog1.takeMedicine(true) shouldBe true
    }

    "do trick" in {
      dog1.doTrick("down") shouldBe true
    }

    "play with toy" in {
      dog1.playWithToy(toy) shouldBe true

      val stream = new java.io.ByteArrayOutputStream()

      Console.withOut(stream) {
        dog1.playWithToy(toy)
      }
      stream.toString should include ("I've got a toy: Ball!")

    }

    "play with toy 2" in {
      val squeaky_toy = Toy("Ball", true)
      dog1.playWithToy(squeaky_toy) shouldBe true

      val regular_toy = Toy("Ball", false)
      dog1.playWithToy(regular_toy) shouldBe (true)
    }

    "guard" in {
      dog1.guardHome() shouldBe true
    }
  }
}
