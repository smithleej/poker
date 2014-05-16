package poker.player.hand

/**
 * @version created on 08/05/14, 16:01
 */
object Hand extends Enumeration {
  val RoyalFlush, StraightFlush, FourOfAKind, FullHouse, Flush, Straight, ThreeOfAKind, TwoPairs, OnePair, HighCard = Value
}