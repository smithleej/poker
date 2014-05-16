package poker.player.hand.evaluator

import poker.CardDTO
import poker.player.hand.Hand

/**
 * @version created on 16/05/14, 13:52
 */
class OnePairEvaluator extends HandEvaluator {
  val hand = Hand.OnePair

  def has(cards: List[CardDTO]): Boolean = {
    if (ofAKind(cards, 2, 1)) true
    else false
  }

  def possible(cards: List[CardDTO]): Boolean = {
    false
  }
}
