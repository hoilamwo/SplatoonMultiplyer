package model.player

import scala.collection.mutable.ListBuffer

class Player( inputLocation: PhysicsVector, inputVelocity: PhysicsVector){

  var destroyed: Boolean = false
  var velocity: PhysicsVector = new PhysicsVector(0, 0)
  val speed: Double = 250.0
  var location: PhysicsVector = inputLocation

  def destroy(): Unit = {
    destroyed = true
  }

  def move(direction: PhysicsVector){
    val normalDirection = direction.normal2d()
    this.velocity = new PhysicsVector(normalDirection.x * speed, normalDirection.y * speed)
  }

  def stop(): Unit ={
    this.velocity = new PhysicsVector(0, 0)
  }

}
