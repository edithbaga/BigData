package mx.com.edithbaga.poc.distribute.actors.across.several.nodes

import mx.com.edithbaga.poc.distribute.actors.across.several.nodes.Control.{Intersection, Wrapping}

object Choice {

  def whereWrapingGo(intersection: Intersection, wrapping: Wrapping): String = {
    Thread.sleep(5)
    val seed = util.Random.nextInt(10000)
    s"JOIN_${intersection.id}_$seed"
  }

}
