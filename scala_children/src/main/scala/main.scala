package runtime

import akka.actor._
import family._

object Main extends App {
  val system = ActorSystem("KidsActorSystem")
  val parentActor = system.actorOf(Parent.props())

  parentActor ! MeasureKidSize
  parentActor ! FeedKid
  parentActor ! FeedKid
  parentActor ! KillKid
  Thread.sleep(100)
  parentActor ! MeasureKidSize
  Thread.sleep(1000)
  system.terminate
}
