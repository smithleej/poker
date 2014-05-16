package poker.player.hand.evaluator

import poker.CardDTO
import poker.player.hand.Hand

/**
 * @version created on 16/05/14, 13:47
 */
class RoyalFlushEvaluator extends HandEvaluator {
  val hand = Hand.RoyalFlush

  def royalStraight(cards: List[CardDTO]): Boolean = {
    cards.head.getValue == CardDTO.Value.TEN
  }

  def has(cards: List[CardDTO]): Boolean = {
    if (royalStraight(cards) && sameSuit(cards)) true
    else false
  }

  def possible(cards: List[CardDTO]): Boolean = {
    if (sameSuit(cards) && possibleRun(cards) && royalStraight(cards)) true
    else false
  }
}
