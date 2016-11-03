package runtime

import akka.actor._
import example._

object Main extends App {

  val system = ActorSystem("KidsActorSystem")
  val exampleActor = system.actorOf(Example.props())

  exampleActor ! Hello("World")

  system.terminate
}














/*
val backoffBuilder =
    (childName: String, childProbs: Props) => {
      Backoff.onStop(
        childProps = childProbs,
        childName = childName,
        minBackoff = 1.second,
        maxBackoff = 16.seconds,
        randomFactor = 0.0 // creates some noise to vary intervals (in %)
      )
    }

  val supervisor = BackoffSupervisor.props(
    backoffBuilder("Adult1", Adult.props())
  )

  val adult = system.actorOf(supervisor, "AdultSupervisor")

  adult ! Adult.MakeKid
  adult ! Adult.CountKids
  adult ! Adult.MeasureKids
  adult ! Adult.PokeKids
  adult ! Adult.FeedKids
  adult ! Adult.FeedKids
  adult ! Adult.MakeKid
  adult ! Adult.CountKids
  adult ! Adult.MeasureKids
  adult ! Adult.PokeKids
  adult ! Adult.FeedKids
  adult ! Adult.FeedKids
  adult ! Adult.PokeKids
  adult ! Adult.MeasureKids

  Thread.sleep(100)

  adult ! Adult.KillKids

  Thread.sleep(100)

  adult ! Adult.CountKids

  Thread.sleep(100)
*/
