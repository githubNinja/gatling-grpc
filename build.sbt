enablePlugins(GatlingPlugin)

scalaVersion := "2.13.10"

scalacOptions := Seq(
  "-encoding", "UTF-8",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps")

val gatlingVersion = "3.9.0"
val gatlingCore = "io.gatling" % "gatling-core" % gatlingVersion

libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % gatlingVersion % "test,it"
libraryDependencies += "io.gatling"            % "gatling-core"    % gatlingVersion % "test,it"
libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.2"

Compile / PB.targets := Seq(
  scalapb.gen() -> (Compile / sourceManaged).value / "scalapb"

)

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)

libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"

libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % scalapb.compiler.Version.grpcJavaVersion,
  "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf",
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % scalapb.compiler.Version.scalapbVersion,
  gatlingCore,
  "com.github.phisgr" % "gatling-ext" % "0.4.0",
  "io.gatling.highcharts" % "gatling-charts-highcharts" % gatlingVersion % "test",
  "io.gatling" % "gatling-test-framework" % gatlingVersion % "test",
  "org.scalatest" %% "scalatest" % "3.2.12" % "test",
)

libraryDependencies += "com.github.phisgr" % "gatling-grpc" % "0.16.0" % "test,it"
