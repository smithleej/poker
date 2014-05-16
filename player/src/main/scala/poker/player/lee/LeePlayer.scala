package poker.player.lee

import poker._
import scala.collection.JavaConversions._
import poker.player._
import poker.player.lee.Fold
import poker.player.lee.Call
import poker.player.lee.AllIn

/**
 * @version created on 08/05/14, 13:32
 */
class LeePlayer extends Player {

  override def name(): String = "Lee"

  def makeMove(pi: PlayerStateDTO, table: TableDTO): MoveDTO = {
    MoveEvaluator.getRecommendedMove(pi.getCards.toList ::: table.getCommunityCards.toList) match {
      case Call() => MoveDTO.CALL
      case Fold() => MoveDTO.FOLD
      case AllIn() => MoveDTO.ALL_IN
      case Raise(amount) => MoveDTO.raise(amount)
    }
  }
}
