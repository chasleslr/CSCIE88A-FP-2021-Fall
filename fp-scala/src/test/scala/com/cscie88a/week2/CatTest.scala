package com.cscie88a.week2

import com.cscie88a.testutils.StandardTest

class CatTest extends StandardTest {

  "Cat" should {
    val cat1 = Cat("kitty", "blue", "brown")
    "not take medicine" in {
      cat1.takeMedicine(true).shouldBe(false)
    }

    "play with toy" in {
      val toy = Toy("Ball", true)
      cat1.playWithToy(toy) shouldBe (true)

      val stream = new java.io.ByteArrayOutputStream()

      Console.withOut(stream) {
        cat1.playWithToy(toy)
      }
      stream.toString should include ("I've got a toy: Ball!")
    }

    "play with toy 2" in {
      val squeaky_toy = Toy("Ball", true)
      cat1.playWithToy(squeaky_toy) shouldBe (true)

      val regular_toy = Toy("Ball", false)
      cat1.playWithToy(regular_toy) shouldBe (false)
    }

    "guard" in {
      cat1.guardHome() shouldBe false
    }
  }
}
