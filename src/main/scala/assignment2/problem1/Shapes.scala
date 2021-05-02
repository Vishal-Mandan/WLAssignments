package assignment2.problem1

abstract class Shape(positionX: Int, positionY: Int) {
  def printElements: String = s"($positionX,$positionY)"
}

case class Rectangle(posX: Int, posY: Int, width: Int, height: Int) extends Shape(posX, posY) {
  override def printElements: String = s"Ractangle ($posX,$posY) width=$width height=$height"
}

case class Square(posX: Int, posY: Int, width: Int) extends Shape(posX, posY) {
  override def printElements: String = s"Square ($posX,$posY) width=$width"
}

case class Ellipse(posX: Int, posY: Int, horizontalDiameter: Int, verticalDiameter: Int) extends Shape(posX, posY) {
  override def printElements: String = s"Ellipse ($posX,$posY) horizontal diameter=$horizontalDiameter vertical diameter=$verticalDiameter"
}

case class Circle(posX: Int, posY: Int, diameter: Int) extends Shape(posX, posY) {
  override def printElements: String = s"Circle ($posX,$posY) diameter=$diameter"
}

case class Textbox(posX: Int, posY: Int, width: Int, height: Int, text: Option[String]) extends Shape(posX, posY) {
  override def printElements: String = s"Textbox ($posX,$posY) width=$width height=$height text=${text.get}"
}
