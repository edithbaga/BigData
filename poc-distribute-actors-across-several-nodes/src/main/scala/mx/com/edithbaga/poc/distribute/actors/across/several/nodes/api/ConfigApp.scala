package mx.com.edithbaga.poc.distribute.actors.across.several.nodes.api


import akka.actor.{Props, ActorSystem}
import akka.cluster.sharding.{ClusterSharding, ClusterShardingSettings}
import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.OrderDecider
import com.typesafe.config.ConfigFactory


object ConfigApp extends App{

  val config = ConfigFactory.load("distribute")
  implicit val system = ActorSystem(config getString "application.name", config)

  ClusterSharding(system).start(
    typeName = OrderDecider.name,
    entityProps = OrderDecider.props,
    settings = ClusterShardingSettings(system),
    extractShardId = OrderDecider.extractShardId,
    extractEntityId = OrderDecider.extractEntityId
  )
  val decider = ClusterSharding(system).shardRegion(OrderDecider.name)
  system.actorOf(Props(new ServiceRest(decider, config getInt "application.exposed-port")))

}