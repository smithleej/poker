package poker.player.lee.hand.evaluator

import poker.CardDTO
import poker.player.lee.hand.Hand

/**
 * @version created on 16/05/14, 13:50
 */
class ThreeOfAKindEvaluator extends HandEvaluator {
  val hand = Hand.ThreeOfAKind

  def has(cards: List[CardDTO]): Boolean = {
    if (ofAKind(cards, 3, 1)) true
    else false
  }

  def possible(cards: List[CardDTO]): Boolean = {
    false
  }
}
