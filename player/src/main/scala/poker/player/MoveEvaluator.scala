package poker.player

import poker.CardDTO
import poker.player.hand.{HandEvaluatorUtil, Hand}

/**
 * @version created on 08/05/14, 16:27
 */
object MoveEvaluator {
  def getRecommendedMove(cards: List[CardDTO]): Move = {
    if (cards.size == 5) {
      // When all cards are dealt
      HandEvaluatorUtil.getBestHand(cards) match {
        case Hand.RoyalFlush => AllIn()
        case Hand.StraightFlush => Raise(10)
        case Hand.FourOfAKind => Raise(5)
        case Hand.FullHouse => Raise(3)
        case Hand.Flush => Raise(1)
        case Hand.Straight => Call()
        case Hand.ThreeOfAKind => Call()
        case Hand.TwoPairs => Call()
        case Hand.OnePair => Fold()
        case Hand.HighCard => Fold()
      }
    } else if (cards.size > 2) {
      HandEvaluatorUtil.getBestPossibleHand(cards) match {
        case Hand.RoyalFlush => Raise(10)
        case Hand.StraightFlush => Raise(5)
        case Hand.FourOfAKind => Raise(3)
        case Hand.FullHouse => Raise(1)
        case Hand.Flush => Call()
        case Hand.Straight => Call()
        case Hand.ThreeOfAKind => Call()
        case Hand.TwoPairs => Call()
        case Hand.OnePair => Call()
        case Hand.HighCard => Fold()
      }
    } else {
      HandEvaluatorUtil.getBestPossibleHand(cards) match {
        case Hand.RoyalFlush => Raise(5)
        case Hand.StraightFlush => Raise(3)
        case Hand.FourOfAKind => Raise(1)
        case Hand.FullHouse => Call()
        case Hand.Flush => Call()
        case Hand.Straight => Call()
        case Hand.ThreeOfAKind => Call()
        case Hand.TwoPairs => Call()
        case Hand.OnePair => Call()
        case Hand.HighCard => Call()
      }
    }
  }
}
