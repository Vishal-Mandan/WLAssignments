package assignment1.problem2

import org.scalatest.FunSuite

class HandTest extends FunSuite {

  test("isTwoPairs method must return true for two pair of cards") {
    val hand = new Hand(Seq(Card("2", Spade), Card("2", Diamond), Card("3", Heart), Card("3", Diamond), Card("5", Spade)))
    assert(hand.isTwoPairs == true)
  }

  test("isTwoPairs method must return false for two pair of cards") {
    val hand = new Hand(Seq(Card("2", Spade), Card("2", Diamond), Card("3", Heart), Card("4", Diamond), Card("5", Spade)))
    assert(hand.isTwoPairs == false)
  }

  test("isFlush should return true for same suit") {
    val hand = new Hand(Seq(Card("2", Spade), Card("9", Spade), Card("3", Spade), Card("T", Spade), Card("5", Spade)))
    assert(hand.isFlush == true)
  }
  test("isFlush should return false for other suit") {
    val hand = new Hand(Seq(Card("2", Heart), Card("9", Spade), Card("3", Spade), Card("T", Spade), Card("5", Spade)))
    assert(hand.isFlush == false)
  }

  test("isFullHouse should return true for three of a kind and a pair") {
    val hand = new Hand(Seq(Card("2", Spade), Card("2", Diamond), Card("2", Heart), Card("4", Diamond), Card("4", Spade)))
    assert(hand.isFullHouse == true)
  }
  test("isFullHouse should return false if not three of a kind and a pair") {
    val hand = new Hand(Seq(Card("J", Spade), Card("2", Diamond), Card("2", Heart), Card("4", Diamond), Card("4", Spade)))
    assert(hand.isFullHouse == false)
  }

  test("isOnePairs should return true for one pair") {
    val hand = new Hand(Seq(Card("2", Spade), Card("2", Diamond), Card("3", Heart), Card("4", Diamond), Card("5", Spade)))
    assert(hand.isOnePairs == true)
  }
  test("isOnePairs should return false if no pair") {
    val hand = new Hand(Seq(Card("2", Spade), Card("2", Diamond), Card("2", Heart), Card("4", Diamond), Card("5", Spade)))
    assert(hand.isOnePairs == false)
  }


  test("isHighCard should always be true if lenght of final map is 5") {
    val hand = new Hand(Seq(Card("2", Spade), Card("6", Diamond), Card("3", Heart), Card("4", Diamond), Card("A", Spade)))
    assert(hand.isHighCard == true)
  }
  test("isHighCard should always be false if there is a pair or something else") {
    val hand = new Hand(Seq(Card("2", Spade), Card("6", Diamond), Card("A", Heart), Card("4", Diamond), Card("A", Spade)))
    assert(hand.isHighCard == false)
  }

  test("isRoyalFlush should return true if it has elite cards and of same suit") {
    val hand = new Hand(Seq(Card("A", Spade), Card("T", Spade), Card("K", Spade), Card("J", Spade), Card("Q", Spade)))
    assert(hand.isRoyalFlush == true)
  }
  test("isRoyalFlush should return false if it has elite cards but no same suit") {
    val hand = new Hand(Seq(Card("A", Spade), Card("T", Spade), Card("K", Heart), Card("J", Spade), Card("Q", Spade)))
    assert(hand.isRoyalFlush == false)
  }

  test("isStraightFlush should return true if it has a sequence and are of same suit") {
    val hand = new Hand(Seq(Card("2", Spade), Card("3", Spade), Card("4", Spade), Card("5", Spade), Card("6", Spade)))
    assert(hand.isStraightFlush == true)
  }

  test("isStraightFlush should return false if it has a sequence and are of differet suit") {
    val hand = new Hand(Seq(Card("2", Heart), Card("3", Spade), Card("4", Spade), Card("5", Spade), Card("6", Spade)))
    assert(hand.isStraightFlush == false)
  }

  test("isStraight should return true for consequtive cards of different suit") {
    val hand = new Hand(Seq(Card("2", Spade), Card("6", Diamond), Card("3", Heart), Card("4", Diamond), Card("5", Spade)))
    assert(hand.isStraight == true)
  }

  test("isStraight should return false for no sequence cards of different suit") {
    val hand = new Hand(Seq(Card("2", Spade), Card("A", Diamond), Card("3", Heart), Card("4", Diamond), Card("5", Spade)))
    assert(hand.isStraight == false)
  }

  test("isThreeOfAKind should return true for 3 cards of same rank") {
    val hand = new Hand(Seq(Card("2", Spade), Card("2", Diamond), Card("2", Heart), Card("4", Diamond), Card("5", Spade)))
    assert(hand.isThreeOfAKind == true)
  }
  test("isThreeOfAKind should return false for no 3 cards of same rank") {
    val hand = new Hand(Seq(Card("2", Spade), Card("2", Diamond), Card("A", Heart), Card("4", Diamond), Card("5", Spade)))
    assert(hand.isThreeOfAKind == false)
  }

  test("isFourOfAKind should return true for 4 cards of same rank") {
    val hand = new Hand(Seq(Card("9", Spade), Card("9", Diamond), Card("9", Heart), Card("9", Club), Card("5", Spade)))
    assert(hand.isFourOfAKind == true)
  }

  test("isFourOfAKind should return true for no 4 cards of same rank") {
    val hand = new Hand(Seq(Card("9", Spade), Card("9", Diamond), Card("Q", Heart), Card("9", Club), Card("5", Spade)))
    assert(hand.isFourOfAKind == false)
  }

}
