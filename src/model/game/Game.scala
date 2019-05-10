package model.game

import model.player.{PhysicsVector, Player}
import play.api.libs.json.{JsArray, JsValue, Json}

class Game {

  //Last Update Time
  var lastUpdateTime: Long = System.nanoTime()

  //Players in Game
  var players: Map[String, Player] = Map()

  //Start Game
  def startGame(): Unit = {
    players.values.foreach(player => player.location = new PhysicsVector(0,0))
  }

  //Add Players in Game
  def addPlayer(id: String): Unit = {
    val x = scala.util.Random
    val y = scala.util.Random
    val startX = x.nextInt(1500)
    val startY = y.nextInt(800)
    val player = new Player(new PhysicsVector(startX, startY), new PhysicsVector(0, 0))
    players += (id -> player)
  }

  //Remove Players
  def removePlayer(id: String): Unit = {
    players(id).destroy()
    players -= id
  }

  //Update Game
  def update(): Unit = {
    val time: Long = System.nanoTime()
    val dt = (time - this.lastUpdateTime) / 1000000000.0
    Update.updateGame(this, dt)
    this.lastUpdateTime = time
  }


  //Game State as JSON
  def gameState(): String = {
    val gameState: Map[String, JsValue] = Map(
      "players" -> Json.toJson(this.players.map({ case (k, v) => Json.toJson(Map(
        "x" -> Json.toJson(v.location.x),
        "y" -> Json.toJson(v.location.y),
        "v_x" -> Json.toJson(v.velocity.x),
        "v_y" -> Json.toJson(v.velocity.y),
        "id" -> Json.toJson(k)))}))
    )
    Json.stringify(Json.toJson(gameState))
  }

}
