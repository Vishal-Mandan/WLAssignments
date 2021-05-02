package assignment2.problem1

import org.scalatest.{FlatSpec, Matchers, WordSpecLike}

class BuilderTest extends WordSpecLike with Matchers {

  "When Builder is called with different shapes" should {
    "then return receipts for the given shapes" in {
      val expectedString = "\n----------------------------------------------------------------\nBill of Materials\n----------------------------------------------------------------\nRactangle (10,10) width=5 height=10\nCircle (10,20) diameter=5\n----------------------------------------------------------------"
      val receipt = Builder.generateBill(Seq(Rectangle(10, 10, 5, 10), Circle(10, 20, 5)))
      assert(receipt == expectedString)
    }

    "then generate receipts for all the shapes" in {
      val expectedString = "\n----------------------------------------------------------------\nBill of Materials\n----------------------------------------------------------------\nRactangle (10,10) width=5 height=10\nCircle (10,20) diameter=5\nEllipse (20,15) horizontal diameter=10 vertical diameter=9\nSquare (10,10) width=10\nTextbox (20,35) width=70 height=50 text=sometext\n----------------------------------------------------------------"
      val receipt = Builder.generateBill(Seq(Rectangle(10, 10, 5, 10), Circle(10, 20, 5), Ellipse(20, 15, 10, 9), Square(10, 10, 10), Textbox(20, 35, 70, 50, Some("sometext"))))
      assert(receipt == expectedString)
    }

    "then generate receipt with abort message" in {
      val expectedString = "+++++Abort++++++"
      val receipt = Builder.generateBill(Seq.empty)
      assert(receipt == expectedString)
    }
  }
}
