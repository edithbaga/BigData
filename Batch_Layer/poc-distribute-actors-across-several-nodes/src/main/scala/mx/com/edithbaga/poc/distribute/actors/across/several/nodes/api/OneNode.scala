package mx.com.edithbaga.poc.distribute.actors.across.several.nodes.api

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory
import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.OrderDecider.OrderDecider


object OneNode extends App {

  val config = ConfigFactory.load()

  implicit val system = ActorSystem(config getString "application.name")

  val decider = system.actorOf(Props[OrderDecider])
  system.actorOf(Props(classOf[ServiceRest], decider, 8080))

}