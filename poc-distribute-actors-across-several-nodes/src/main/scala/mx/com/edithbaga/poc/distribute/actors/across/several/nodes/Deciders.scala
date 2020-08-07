package mx.com.edithbaga.poc.distribute.actors.across.several.nodes

import akka.actor.{Actor, Props}
import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.Messages._
import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.OrderDecider._


class Deciders extends Actor{

  def receive = {
    case m: WhereToGo =>
      val name = s"J${m.intersection.id}"
      val actor = context.child(name) getOrElse context.actorOf(Props[OrderDecider], name)
      actor forward m
  }

}
