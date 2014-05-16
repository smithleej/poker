package poker.player.lee

/**
 * @version created on 08/05/14, 16:20
 */
trait Move

case class Call() extends Move

case class Fold() extends Move

case class Raise(amount: Int) extends Move

case class AllIn() extends Move
