package family

import akka.actor.{ Props, Actor }

object Child {
  def props() :Props = Props(classOf[Child])
}

class Child extends Actor {
  var currentSize = 55
  def receive = {
    case Feed => {
      currentSize += 1
      sender() ! KidSize(currentSize)
    }
    case TellMeSize => sender() ! KidSize(currentSize)
    case _ => println("Example received unknown message")
  }
}
