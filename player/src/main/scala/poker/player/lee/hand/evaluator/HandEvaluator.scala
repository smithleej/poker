package poker.player.hand.evaluator

import poker.CardDTO
import poker.player.hand.Hand

/**
 * All hand evaluators must implement has() and possible().
 *
 * @version created on 16/05/14, 13:44
 */
trait HandEvaluator {
  val hand: Hand.Value

  /**
   * Test if a hand is available given 5 cards.
   */
  def has(cards: List[CardDTO]): Boolean

  /**
   * Test a hand is possible when cards are still to be dealt.
   */
  def possible(cards: List[CardDTO]): Boolean

  def sameSuit(cards: List[CardDTO]): Boolean = {
    cards.forall(_.getSuit == cards.head.getSuit)
  }

  def run(cards: List[CardDTO]): Boolean = {
    val toMinus = cards.head.getValue.value - 2 /*lowest card value*/
    cards.foldLeft(toMinus * 5 /*five cards*/)(_ + _.getValue.value) == 20 /*cards sum starting with lowest value card*/
  }

  def ofAKind(cards: List[CardDTO], num: Int, count: Int): Boolean = {
    cards.groupBy(_.getValue.value).count(_._2.size >= num) == count
  }

  def possibleRun(cards: List[CardDTO]): Boolean = {
    cards.last.getValue.value - cards.head.getValue.value < 5
  }
}
