package assignment1.problem2

class Card(val rank: String, val suit: Suit, val card: String) {
  override def toString: String = card
}

object Card {
  //TODO details need to be validated here
  def apply(rank: String, suit: Suit): Card = new Card(rank, suit, rank + suit.displayId)
}
