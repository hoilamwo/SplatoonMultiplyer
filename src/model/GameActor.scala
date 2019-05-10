package model

import akka.actor.{Actor, ActorRef}
import model.game.{Game}
import model.player.PhysicsVector

class GameActor extends Actor{

  var players: Map[String, ActorRef] = Map()
  val game: Game = new Game()

  startGame()

  def startGame(): Unit ={
    game.startGame()
  }

  override def receive: Receive = {
    case message: AddPlayer => game.addPlayer(message.username)
    case message: RemovePlayer => game.removePlayer(message.username)
    case message: MovePlayer => game.players(message.username).move(new PhysicsVector(message.x, message.y))
    case message: StopPlayer => game.players(message.username).stop()

    case UpdateGame => game.update()
    case SendGameState =>
      sender() ! GameState(game.gameState())
//      println(game.gameState())
  }
}
