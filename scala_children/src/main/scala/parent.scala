package family

import akka.actor._

object Parent {
  def props() :Props = Props(classOf[Parent])
}

class Parent extends BaseParent {
  def spawnChild(context: ActorContext) = {
    context.system.actorOf(Child.props())
  }
}
