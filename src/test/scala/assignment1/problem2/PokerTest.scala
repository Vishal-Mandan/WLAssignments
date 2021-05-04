package assignment1.problem2

import org.scalatest.{Matchers, WordSpecLike}

class PokerTest extends WordSpecLike with Matchers {

  "When getWinner count is called then it" should {
    "return correct output for filename poker.txt" in {
      val expectedCount = 359
      val result = Poker.getWinner("poker.txt")
      assert(result == expectedCount)
    }

    "return correct output for filename triangle.txt" in {
      val expectedCount = 2
      val result = Poker.getWinner("poker1.txt")
      assert(result == expectedCount)
    }
  }
}
