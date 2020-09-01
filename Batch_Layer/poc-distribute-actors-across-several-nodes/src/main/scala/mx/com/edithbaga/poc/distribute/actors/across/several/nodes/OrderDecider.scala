package mx.com.edithbaga.poc.distribute.actors.across.several.nodes

import akka.actor.{Actor, ActorLogging, Props}
import akka.cluster.sharding.ShardRegion.{ExtractEntityId, ExtractShardId}
import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.Messages._

object OrderDecider {

  def name = "orderDecider"

  def props = Props[OrderDecider]

  def extractShardId: ExtractShardId = {
    case WhereToGo(intersection, _) =>
      (intersection.id).toString
  }

  def extractEntityId: ExtractEntityId = {
    case msg @ WhereToGo(intersection, _) =>
      (intersection.id.toString, msg)
  }

  class OrderDecider extends Actor with ActorLogging {
    def receive = {
      case WhereToGo(intersection, wrapping) =>
        val choice = Choice.whereWrapingGo(intersection, wrapping)
        log.info("Choice on intersection {}  for wrapping {}: {}", intersection.id, wrapping.id, choice)
        sender ! GoTo(choice)
    }
  }
}
