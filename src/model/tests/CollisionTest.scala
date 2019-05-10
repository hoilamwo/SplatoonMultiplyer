package model.tests

import org.scalatest._

class CollisionTest extends FunSuite{
  test("Test collision"){
    //intersect
    val po: PhysicalObject = new PhysicalObject(new PhysicsVector(0,0), new PhysicsVector(2,2))
    val poL:PhysicsVector=new PhysicsVector(2,2)
    val bound: Boundary = new Boundary(new PhysicsVector(1,2), new PhysicsVector(2,1))

    //not intersect
    val po1: PhysicsVector = new PhysicsVector(0,0)
    val poL1: PhysicsVector = new PhysicsVector(2,2)
    val bound1: Boundary = new Boundary(new PhysicsVector(1,4), new PhysicsVector(2,3))

    //touching
    val po2: PhysicsVector = new PhysicsVector(0,0)
    val poL2: PhysicsVector = new PhysicsVector(2,2)
    val bound2: Boundary = new Boundary(new PhysicsVector(1,3), new PhysicsVector(3,1))

    val po3: PhysicsVector = new PhysicsVector(0,0)
    val poL3: PhysicsVector = new PhysicsVector(3,2)
    val bound3: Boundary = new Boundary(new PhysicsVector(1,4), new PhysicsVector(3,2))

    val po4: PhysicsVector = new PhysicsVector(0,0)
    val poL4: PhysicsVector = new PhysicsVector(4,4)
    val bound4: Boundary = new Boundary(new PhysicsVector(1,5), new PhysicsVector(3,3))

    assert(Physics.detectCollision(po, poL, bound) == true)
    assert(Physics.detectCollision(po, poL1, bound1) == false)

    assert(Physics.detectCollision(po, poL2, bound2) == false)
    assert(Physics.detectCollision(po, poL3, bound3) == false)
    assert(Physics.detectCollision(po, poL4, bound4) == false)
  }

}
