name := "ScalaIP"
// used as `groupId`
organization := "io.github.jshalaby510"
version := "1.1"
scalaVersion := "2.12.10"
// open source licenses that apply to the project
licenses := Seq("APL2" -> url("https://www.apache.org/licenses/LICENSE-2.0.txt"))
description := "IPv4 and IPv6 Network address manipulation library for Scala."

import xerial.sbt.Sonatype._
sonatypeProjectHosting := Some(GitHubHosting("jshalaby510", "ScalaIP", "io.github.jshalaby510"))
// For all Sonatype accounts created on or after February 2021
sonatypeCredentialHost := "s01.oss.sonatype.org"

// publish to the sonatype repository
publishTo := sonatypePublishToBundle.value

libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.1.1"
libraryDependencies += "com.github.mrpowers" %% "spark-daria" % "0.38.2"
libraryDependencies += "com.github.mrpowers" %% "spark-fast-tests" % "0.21.3" % "test"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
// test suite settings
fork in Test := true
javaOptions ++= Seq("-Xms512M", "-Xmx2048M", "-XX:MaxPermSize=2048M")
// Show runtime of tests
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-oD")

ThisBuild / description := "Some description about your project."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/RyanMatthewJacobs/ScalaIP"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://s01.oss.sonatype.org"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
