package assignment1.problem1

import org.scalatest.{FunSuite, Matchers, WordSpecLike}

class DayCounterTest extends WordSpecLike with Matchers {

  "When Day counter is called then it" should {
    "return correct number of sundays in given start year and end year" in {
      val expectedCount = 173
      val result = DayCounter.calculateNumberOfSundays(1900, 2000)
      assert(result == expectedCount)
    }

    "return correct number of sundays in given start year and end year to a lib function" in {
      val expectedCount = 173
      val result = DayCounter.getSundaysUsingLibFun(1900, 2000)
      assert(result == expectedCount)
    }

    "return correct number of sundays in given start year and end year to a lib function using fold method" in {
      val expectedCount = 173
      val result = DayCounter.getSundaysUsingLibFunFold(1900, 2000)
      assert(result == expectedCount)
    }
  }
}
