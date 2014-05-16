package poker.player.hand.evaluator

import poker.CardDTO
import poker.player.hand.Hand

/**
 * @version created on 16/05/14, 13:50
 */
class StraightEvaluator extends HandEvaluator {
  val hand = Hand.Straight

  def has(cards: List[CardDTO]): Boolean = {
    if (run(cards)) true
    else false
  }

  def possible(cards: List[CardDTO]): Boolean = {
    false
  }
}
