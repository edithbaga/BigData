name := "ProducerAndConsumer"

version := "0.1"

scalaVersion := "2.11.12"

libraryDependencies ++= {
  Seq(
    "org.Apache.kafka" %% "kafka" % "0.8.2.2",
    "org.Apache.kafka" % "kafka-clients" % "0.8.2.2",
  )
}