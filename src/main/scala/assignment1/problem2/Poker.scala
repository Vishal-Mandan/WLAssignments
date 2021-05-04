package assignment1.problem2

import java.nio.file.Paths

import scala.io.Source

object Poker /*extends App*/{
  def getWinner(fileName: String): Int = {
    val inputFile = Source.fromFile(Paths.get("src\\main\\scala\\assignment1\\problem2\\" + fileName).toFile)
    val lines: Iterator[String] = inputFile.getLines()
    val inputHands: Seq[Seq[String]] = lines.map(_.split(" ").toSeq).toSeq

    def getPlayer1Cards(player1: Seq[String]) = {
      val cardsForPlayer1: Seq[Card] = player1.map(x => new Card(x.charAt(0).toString, x.charAt(1) match {
        case 'S' => Spade
        case 'D' => Diamond
        case 'H' => Heart
        case 'C' => Club
      }, x))
      cardsForPlayer1
    }

    var count = 0
    inputHands.foreach {
      hands => {
        val (firstColumn, secondsColumn) = hands.splitAt(5)
        val player1WithCards = new Hand(getPlayer1Cards(firstColumn))
        val player2WithCards = new Hand(getPlayer1Cards(secondsColumn))
        val winner = Helper.getResult(player1WithCards, player2WithCards)
        if (winner == player1WithCards) count += 1
      }
    }
    count
  }

  /*print(getWinner("poker.txt"))*/ //output is 359 for player 1 wins
}
