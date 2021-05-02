package assignment1.problem3

import scala.io.Source
import java.nio.file.Paths

object Triangle /*extends App*/ {

  def calculateMaxValues(fileName: String): Int = {
    val fileSource = Source.fromFile(Paths.get("src\\main\\scala\\assignment1\\problem3\\" + fileName).toFile)
    val lines: Iterator[String] = fileSource.getLines()
    val triangleInput: Seq[Seq[Int]] = lines.map(_.split(" ").map(_.toInt).toSeq).toSeq

    def sumOfRecords(rowsInTriangle: Int = 0, nextIndex: Int = 0, sum: Int = 0): Int = {
      println(s"Got the $rowsInTriangle th row, index:$nextIndex and the sum:$sum")
      if (rowsInTriangle == triangleInput.size) sum
      else {
        val row = triangleInput(rowsInTriangle)
        if (rowsInTriangle == 0) sumOfRecords(rowsInTriangle + 1, nextIndex, row.head)
        else {
          if (row(nextIndex) > row(nextIndex + 1))
            sumOfRecords(rowsInTriangle + 1, nextIndex, sum + row(nextIndex))
          else
            sumOfRecords(rowsInTriangle + 1, nextIndex + 1, sum + row(nextIndex + 1))
        }
      }
    }
    sumOfRecords()
  }
  //  calculateMaxValue
}
