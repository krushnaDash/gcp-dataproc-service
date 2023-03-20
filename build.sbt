
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"
val ZioVersion    = "2.0.6"
val GcpDpVersion        = "4.7.0"
val GcpGcsVersion       = "2.18.0"
val ScalaJavaCollectionCompat = "2.9.0"
val ZioLogVersion = "2.1.8"
val GcpPubSubVersion    = "1.123.2"

lazy val root = (project in file("."))
  .settings(
    name := "bua-gcp-dp-service"
  )
libraryDependencies ++= List(
  "dev.zio"                %% "zio"                     % ZioVersion,
  "dev.zio"                %% "zio-streams"             % ZioVersion,
  "org.scala-lang.modules" %% "scala-collection-compat" % ScalaJavaCollectionCompat,
  "dev.zio"                %% "zio-logging-slf4j"       % ZioLogVersion,
  "com.google.cloud" % "google-cloud-dataproc" % GcpDpVersion,
  "com.google.cloud" % "google-cloud-storage" % GcpGcsVersion,
  "com.google.cloud" % "google-cloud-pubsub" % GcpPubSubVersion,
  "io.grpc" % "grpc-okhttp" % "1.51.3",
  "io.grpc" % "grpc-netty-shaded" % "1.52.1",
  "ch.qos.logback"            % "logback-classic" % "1.4.5",
  "org.slf4j" % "slf4j-api" % "2.0.6"
)

mainClass := Some("dpcluster.DPGCS")

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", _*) => MergeStrategy.discard
  case _                        => MergeStrategy.first
}