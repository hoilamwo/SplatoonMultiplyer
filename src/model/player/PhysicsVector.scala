package model.player

class PhysicsVector(var x: Double, var y: Double) {

  def distance2d(other: PhysicsVector): Double = {
    Math.sqrt(Math.pow(x - other.x, 2.0) + Math.pow(y - other.y, 2.0))
  }

  def normal2d(): PhysicsVector = {
    if (x == 0 && y == 0) {
      new PhysicsVector(0, 0)
    } else {
      val magnitude = Math.sqrt(Math.pow(x, 2.0) + Math.pow(y, 2.0))
      new PhysicsVector(x / magnitude, y / magnitude)
    }
  }

  override def toString: String = {
    "(" + x + ", " + y + ") "
  }

}
