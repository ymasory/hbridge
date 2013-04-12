/* basic project info */
name := "hbridge"

organization := "com.cloudphysics"

version := "2.0.0-SNAPSHOT"

startYear := Some(2012)

licenses := Seq(
  ("The MIT License", url("http://opensource.org/licenses/MIT"))
)

homepage := Some(url("https://github.com/cphylabs/hbridge"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/cphylabs/hbridge"),
    "scm:git:https://github.com/cphylabs/hbridge.git",
    Some("scm:git:git@github.com:cphylabs/hbridge.git")
  )
)

/* scala options */
scalaVersion := "2.9.2"

crossScalaVersions := Seq(
  // "2.9.3",
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
  "-Yinline"
  // "-Yno-adapted-args",
  // "-Ywarn-all"
)

scalacOptions ++= Seq(
  "-Xfatal-warnings"
  // "-Xverify"
  // "-feature"
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
resolvers ++= Seq(
  "Cloudera Releases" at "https://repository.cloudera.com/content/repositories/releases/"
)

libraryDependencies ++= Seq(
  ("org.apache.hbase"   % "hbase"          % "0.92.1-cdh4.0.1").exclude("org.slf4j", "slf4j-log4j12").exclude("org.slf4j", "slf4j-api"),
  ("org.apache.hadoop"  % "hadoop-client"  % "2.0.0-cdh4.0.1").exclude("org.slf4j", "slf4j-log4j12").exclude("org.slf4j", "slf4j-api"),
  "joda-time"           % "joda-time"      % "2.2",
  "org.joda"            % "joda-convert"   % "1.3.1"
)

libraryDependencies <+= scalaVersion { sv =>
  val version = if (sv startsWith "2.10") "1.0.1" else "0.6.10"
  "org.clapper" %% "grizzled-slf4j" % version
}

libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.7" % "provided"
)

libraryDependencies in Runtime ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.7"
)

libraryDependencies in Test ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.0.7"
)

/* sbt behavior */
logLevel in compile := Level.Warn

traceLevel := 5

offline := false

/* publishing */
publishMavenStyle := true

publishTo <<= version { (v: String) =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some(
    "snapshots" at nexus + "content/repositories/snapshots"
  )
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <developers>
    <developer>
      <id>cphylabs</id>
      <name>CloudPhysics Inc</name>
      <email>opensource@cloudphysics.com</email>
    </developer>
  </developers>
)
