package model.game

import model.player.{PhysicsVector, Player}

object Update {

  def ~=(x: Double, y: Double, precision: Double) = {
    if ((x - y).abs < precision) true else false
  }

  //Compute player's potential location to check for collision
  def computePotentialLocation(player: Player, dt: Double): PhysicsVector= {
    val poX: Double = player.location.x + dt * player.velocity.x
    val poY: Double  = player.location.y + dt * player.velocity.y
    new PhysicsVector(poX, poY)
  }

  //Detect if player crossed boundary
  def detectCollision(potentialLocation: PhysicsVector, game: Game): Boolean = {
    val poLocationX: Double = potentialLocation.x
    val poLocationY: Double = potentialLocation.y
    val playerMP: Double = 5
    if(poLocationX <= (-playerMP) || poLocationX >= (1500-playerMP) || poLocationY <= playerMP || poLocationY >= 800-playerMP){
      true
    } else {
      false
    }
  }

  def updateGame(game: Game, dt: Double): Unit = {
    for (player <- game.players.values) {
      val poLo: PhysicsVector = computePotentialLocation(player, dt)
      val collision: Boolean = detectCollision(poLo, game)
      if(!collision){
        player.location.x = poLo.x
        player.location.y = poLo.y
//        if(player.draw.isEmpty){
//          player.draw += poLo
//        } else {
//          if(!(~=(player.draw.last.x, poLo.x, 1)) || !(~=(player.draw.last.y, poLo.y, 1))){
//            player.draw += poLo
////            println(player.draw mkString "")
//          }
//        }
      }
    }
  }
}
