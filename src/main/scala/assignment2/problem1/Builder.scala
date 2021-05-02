package assignment2.problem1

object Builder/* extends App*/ {
  def generateBill(shapes: Seq[Shape]): String = {
    val header =
      s"""
----------------------------------------------------------------
Bill of Materials
---------------------------------------------------------------- """
    val footer = "----------------------------------------------------------------"

    if (shapes.isEmpty)
      "+++++Abort++++++"
    else {
      s"$header\n${shapes.map(_.printElements).mkString("\n")}\n$footer"
    }
  }
  //  println(generateBill(Seq(Rectangle(10, 10, 5, 10), Circle(10, 20, 5))))
}
