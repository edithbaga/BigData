package mx.com.edithbaga.poc.distribute.actors.across.several.nodes.api

import akka.actor.{Actor, ActorLogging, ActorRef}
import akka.io.IO
import akka.pattern.ask
import spray.can.Http
import spray.routing._
import scala.concurrent.duration._
import spray.httpx.SprayJsonSupport._

import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.Control.{Intersection, Wrapping}
import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.Messages._

class ServiceRest(decider: ActorRef, exposedPort: Int) extends Actor with HttpServiceBase with ActorLogging {

  val route: Route = {

    path("intersection" / IntNumber / "choiceForWrapping" / IntNumber) { (intersectionId, wrappingId) =>
      get {
        complete {
          val junction = Intersection(intersectionId)
          val container = Wrapping(wrappingId)
          decider.ask(WhereToGo(junction, container))(5 seconds).mapTo[GoTo]
        }
      }
    }
  }


  def receive = runRoute(route)

  implicit val system = context.system
  IO(Http) ! Http.Bind(self, interface = "0.0.0.0", port = exposedPort)

}