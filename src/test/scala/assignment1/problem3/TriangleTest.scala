package assignment1.problem3

import org.scalatest.{FunSuite, Matchers, WordSpecLike}

class TriangleTest extends WordSpecLike with Matchers {

  "When calculateMaxValues is called then it" should {
    "return correct output for filename triangle1.txt" in {
      val expectedCount = 23
      val result = Triangle.calculateMaxValues("triangle1.txt")
      assert(result == expectedCount)
    }

    "return correct output for filename triangle.txt" in {
      val expectedCount = 6580
      val result = Triangle.calculateMaxValues("triangle.txt")
      assert(result == expectedCount)
    }
  }

}
