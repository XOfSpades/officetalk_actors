package example

import akka.actor.{ Props, Actor, Terminated }

final case class Hello(var name: String)

object Example {
  def props() :Props = Props(classOf[Example])
}

class Example extends Actor {
  def receive = {
    case Hello(name) => { println("Hello " + name) }
    case _ => println("Example received unknown message")
  }
}
