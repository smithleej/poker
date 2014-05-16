package poker.player.lee.hand

import poker.CardDTO
import poker.player.lee.hand.evaluator._

/**
 * A utility to get the best hand when all cards are dealt or the best possible hand if there are still cards to deal.
 *
 * @version created on 08/05/14, 15:40
 */
object HandEvaluatorUtil {
  val evaluators = List(new RoyalFlushEvaluator, new StraightFlushEvaluator, new FourOfAKindEvaluator, new FullHouseEvaluator,
    new FlushEvaluator, new StraightEvaluator, new ThreeOfAKindEvaluator, new TwoPairsEvaluator, new OnePairEvaluator)

  private def evaluateHand(cards: List[CardDTO], evaluators: List[HandEvaluator], func: (HandEvaluator, List[CardDTO]) => Boolean): Hand.Value = {
    if (evaluators.isEmpty) Hand.HighCard
    else if (func(evaluators.head, cards)) evaluators.head.hand
    else evaluateHand(cards, evaluators.tail, func)
  }

  def getBestHand(cards: List[CardDTO]) = {
    evaluateHand(cards.sortBy(_.getValue.value), evaluators, (evaluator: HandEvaluator, cards) => evaluator.has(cards))
  }

  def getBestPossibleHand(cards: List[CardDTO]) = {
    evaluateHand(cards.sortBy(_.getValue.value), evaluators, (evaluator: HandEvaluator, cards) => evaluator.possible(cards))
  }
}