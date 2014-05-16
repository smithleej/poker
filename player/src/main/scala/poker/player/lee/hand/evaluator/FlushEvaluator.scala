package poker.player.lee.hand.evaluator

import poker.CardDTO
import poker.player.lee.hand.Hand

/**
 * @version created on 16/05/14, 13:49
 */
class FlushEvaluator extends HandEvaluator {
  val hand = Hand.Flush

  def has(cards: List[CardDTO]): Boolean = {
    if (sameSuit(cards)) true
    else false
  }

  def possible(cards: List[CardDTO]): Boolean = {
    false
  }
}
