package model.tests

import model.physics.{PhysicalObject, Physics, PhysicsVector}
import org.scalatest._

class TestComputeLocation extends FunSuite {

  val EPSILON: Double = 0.000001

  def equalDoubles(d1: Double, d2: Double): Boolean = {
    (d1 - d2).abs < EPSILON
  }

  def equalVectors(v1: PhysicsVector, v2: PhysicsVector): Boolean = {
    equalDoubles(v1.x, v2.x) && equalDoubles(v1.y, v2.y)
  }

  test("Physical objects move") {
    val o1: PhysicalObject = new PhysicalObject(new PhysicsVector(0, 0), new PhysicsVector(1, -2))
    val newLocation: PhysicsVector = Physics.computePotentialLocation(o1, 1.0)
    assert(equalVectors(newLocation, new PhysicsVector(1, -2)))

    val o2: PhysicalObject = new PhysicalObject(new PhysicsVector(0.4, -1.6), new PhysicsVector(1.3, -2.1))
    val newLocation2: PhysicsVector = Physics.computePotentialLocation(o2, 1.4)
    assert(equalVectors(newLocation2, new PhysicsVector(2.22, -4.54)))

    val o3: PhysicalObject = new PhysicalObject(new PhysicsVector(1, 1), new PhysicsVector(0, 0))
    val newLocation3: PhysicsVector = Physics.computePotentialLocation(o3, 1.2)
    assert(equalVectors(newLocation3, new PhysicsVector(1, 1)))

  }

}