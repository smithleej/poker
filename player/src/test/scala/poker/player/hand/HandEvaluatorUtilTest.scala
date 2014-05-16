package poker.player.hand

import org.scalatest.FunSuite
import poker.CardDTO
import poker.CardDTO.Suit._
import poker.CardDTO.Value._

/**
 * TODO comment
 *
 * @version created on 16/05/14, 11:08
 */
class HandEvaluatorUtilTest extends FunSuite {
  /*Royal Flush tests*/
  test("testGetBestHandRoyalFlush") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, QUEEN), new CardDTO(HEARTS, KING), new CardDTO(HEARTS, TEN), new CardDTO(HEARTS, ACE), new CardDTO(HEARTS, JACK))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.RoyalFlush)(bestHand)
  }
  test("royal flush possible with 4 cards") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, QUEEN), new CardDTO(HEARTS, TEN), new CardDTO(HEARTS, ACE), new CardDTO(HEARTS, JACK))
    val bestHand = HandEvaluatorUtil.getBestPossibleHand(cards)
    assertResult(Hand.RoyalFlush)(bestHand)
  }
  test("royal flush possible with 3 cards") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, QUEEN), new CardDTO(HEARTS, TEN), new CardDTO(HEARTS, JACK))
    val bestHand = HandEvaluatorUtil.getBestPossibleHand(cards)
    assertResult(Hand.RoyalFlush)(bestHand)
  }
  test("royal flush possible with 2 cards") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, QUEEN), new CardDTO(HEARTS, TEN))
    val bestHand = HandEvaluatorUtil.getBestPossibleHand(cards)
    assertResult(Hand.RoyalFlush)(bestHand)
  }
  test("royal flush not possible with 4 cards due to not straight") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, QUEEN), new CardDTO(HEARTS, TWO), new CardDTO(HEARTS, ACE), new CardDTO(HEARTS, JACK))
    val bestHand = HandEvaluatorUtil.getBestPossibleHand(cards)
    assert(Hand.RoyalFlush != bestHand)
  }
  test("royal flush not possible with 4 cards due to not royal straight") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, QUEEN), new CardDTO(HEARTS, TEN), new CardDTO(HEARTS, NINE), new CardDTO(HEARTS, JACK))
    val bestHand = HandEvaluatorUtil.getBestPossibleHand(cards)
    assert(Hand.RoyalFlush != bestHand)
  }
  test("royal flush not possible with 4 cards due to not flush") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, QUEEN), new CardDTO(SPADES, TEN), new CardDTO(HEARTS, ACE), new CardDTO(HEARTS, JACK))
    val bestHand = HandEvaluatorUtil.getBestPossibleHand(cards)
    assert(Hand.RoyalFlush != bestHand)
  }
  /*Straight Flush tests*/
  test("testGetBestHandStraightFlush") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, TWO), new CardDTO(HEARTS, FIVE), new CardDTO(HEARTS, FOUR), new CardDTO(HEARTS, SIX), new CardDTO(HEARTS, THREE))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.StraightFlush)(bestHand)
  }
  /*Four of a Kind tests*/
  test("testGetBestHandFourOfAKind") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, SIX), new CardDTO(HEARTS, FIVE), new CardDTO(CLUBS, SIX), new CardDTO(SPADES, SIX), new CardDTO(DIAMONDS, SIX))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.FourOfAKind)(bestHand)
  }
  /*Full House tests*/
  test("testGetBestHandFullHouse") {
    val cards: List[CardDTO] = List(new CardDTO(SPADES, SIX), new CardDTO(HEARTS, FIVE), new CardDTO(HEARTS, SIX), new CardDTO(CLUBS, FIVE), new CardDTO(DIAMONDS, SIX))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.FullHouse)(bestHand)
  }
  /*Flush tests*/
  test("testGetBestHandFlush") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, NINE), new CardDTO(HEARTS, FIVE), new CardDTO(HEARTS, EIGHT), new CardDTO(HEARTS, SIX), new CardDTO(HEARTS, THREE))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.Flush)(bestHand)
  }
  /*Straight tests*/
  test("testGetBestHandStraight") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, TWO), new CardDTO(HEARTS, FIVE), new CardDTO(SPADES, FOUR), new CardDTO(DIAMONDS, SIX), new CardDTO(CLUBS, THREE))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.Straight)(bestHand)
  }
  /*Three of a Kind tests*/
  test("testGetBestHandThreeOfAKind") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, SIX), new CardDTO(HEARTS, FIVE), new CardDTO(CLUBS, SIX), new CardDTO(SPADES, NINE), new CardDTO(DIAMONDS, SIX))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.ThreeOfAKind)(bestHand)
  }
  /*Two Pairs tests*/
  test("testGetBestHandTwoPairs") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, NINE), new CardDTO(HEARTS, FIVE), new CardDTO(CLUBS, SIX), new CardDTO(SPADES, NINE), new CardDTO(DIAMONDS, SIX))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.TwoPairs)(bestHand)
  }
  /*One Pair tests*/
  test("testGetBestHandOnePair") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, TWO), new CardDTO(HEARTS, FIVE), new CardDTO(CLUBS, SIX), new CardDTO(SPADES, NINE), new CardDTO(DIAMONDS, SIX))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.OnePair)(bestHand)
  }
  /*High Card tests*/
  test("testGetBestHandHighCard") {
    val cards: List[CardDTO] = List(new CardDTO(HEARTS, TWO), new CardDTO(HEARTS, FIVE), new CardDTO(CLUBS, SIX), new CardDTO(SPADES, NINE), new CardDTO(DIAMONDS, KING))
    val bestHand = HandEvaluatorUtil.getBestHand(cards)
    assertResult(Hand.HighCard)(bestHand)
  }
}
