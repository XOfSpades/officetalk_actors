package family

import akka.actor._

trait BaseParent extends Actor {
  def spawnChild(context: ActorContext) :ActorRef

  var child = respawnChild

  def receive = {
    case MeasureKidSize => child ! TellMeSize
    case FeedKid => child ! Feed
    case KillKid => child ! PoisonPill
    case KidSize(size) => println("The child is " + size + "cm tall!")
    case Terminated(childActor) => {
      println("Child actor died. Respawn!")
      child = respawnChild
    }
    case _ => println("Example received unknown message")
  }

  def respawnChild = {
    val childActor = spawnChild(context)
    context.watch(childActor)
    childActor
  }
}
