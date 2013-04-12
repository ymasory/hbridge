organization := "com.cloudphysics"

name := "hbridge"

version := "0.1.0-SNAPSHOT"

startYear := Some(2012)

scalaVersion := "2.10.1"

retrieveManaged := true

crossScalaVersions := Seq(
  "2.9.3",
  "2.9.2",
  "2.9.1", "2.9.1-1",
  "2.9.0", "2.9.0-1",
  "2.8.0", "2.8.1", "2.8.2"
)

scalacOptions ++= Seq(
  "-deprecation",
  "-unchecked",
  "-encoding", "UTF-8",
  "-optimise"
)

scalacOptions ++= Seq(
  "-Yclosure-elim",
  "-Yinline",
  "-Yno-adapted-args",
  "-Ywarn-all"
)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-Xverify",
  "-feature"
  // "-language:postfixOps",
  // "-language:reflectiveCalls",
  // "-language:implicitConversions"
  // "-language:higherKinds",
  // "-language:existentials",
  // "-language:experimental.macros",
  // "-language:experimental.dynamics"
)

javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")

/* dependencies */
libraryDependencies ++= Seq(
  // "org.apache.hbase"   % "hbase"          % "0.95.0",
  // "org.apache.hadoop"  % "hadoop-core"    % "1.1.2",
  "joda-time"          % "joda-time"      % "2.2",
  "org.joda"           % "joda-convert"   % "1.3.1",
  "org.clapper"       %% "grizzled-slf4j" % "1.0.1"
)

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.7" % "provided"
)

libraryDependencies in Runtime ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.7"
)

libraryDependencies in Test ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.7"
)

logLevel in compile := Level.Warn

traceLevel := 5

offline := false
