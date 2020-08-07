package mx.com.edithbaga.poc.distribute.actors.across.several.nodes

import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.Control._
import spray.json.DefaultJsonProtocol._

object Messages {

  case class WhereToGo(intersection: Intersection, wrapping: Wrapping)

  case class GoTo(targetConveyor: String)

  object GoTo {
    implicit val json = jsonFormat1(GoTo.apply)
  }
}
