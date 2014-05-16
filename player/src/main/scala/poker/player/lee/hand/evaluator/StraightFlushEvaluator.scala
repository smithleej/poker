package poker.player.lee.hand.evaluator

import poker.CardDTO
import poker.player.lee.hand.Hand

/**
 * @version created on 16/05/14, 13:48
 */
class StraightFlushEvaluator extends HandEvaluator {
  val hand = Hand.StraightFlush

  def has(cards: List[CardDTO]): Boolean = {
    if (sameSuit(cards) && run(cards)) true
    else false
  }

  def possible(cards: List[CardDTO]): Boolean = {
    false
  }
}
