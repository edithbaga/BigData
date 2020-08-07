name := "poc-distribute-actors-across-several-nodes"

version := "0.1"

scalaVersion := "2.11.8"
val akkaVersion = "2.4.10"

libraryDependencies ++= Seq(

  "org.scala-lang" % "scala-library" % "2.11.8",
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
  "com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-distributed-data-experimental" % "2.4.11.1",
  "com.typesafe.akka" %% "akka-slf4j" % "2.5.24",
  "com.typesafe" % "config" % "1.3.0",
  "io.spray" %% "spray-can" % "1.3.2",
  "io.spray" %% "spray-routing" % "1.3.2",
  "io.spray" %% "spray-httpx" % "1.3.2",
  "io.spray" %% "spray-routing" % "1.3.2",
  "io.spray" %% "spray-json" % "1.3.2",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
  "junit" % "junit" % "4.13-beta-1" % Test,
  "com.typesafe.akka" %% "akka-testkit" % "2.5.31" % Test
)