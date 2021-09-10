package com.cscie88a.week2

import com.cscie88a.testutils.StandardTest

class HedgehogTest extends StandardTest {
  "HedgeHog" should {
    val hedgehog = Hedgehog("spiky", "brown", "brown")
    "play with toy" in {
      val squeaky_toy = Toy("Ball", true)
      hedgehog.playWithToy(squeaky_toy) shouldBe (true)

      val regular_toy = Toy("Ball", false)
      hedgehog.playWithToy(regular_toy) shouldBe (false)
    }

    "guard" in {
      hedgehog.guardHome() shouldBe false
    }
  }
}