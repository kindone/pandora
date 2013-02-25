name := "Pandora"

version := "0.3"

scalaVersion := "2.9.1"

scalacOptions += "-Ydependent-method-types"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "FWBrasil" at "http://fwbrasil.net/maven",
	"Local Maven Repository" at "file://"+Path.userHome+"/.m2/repository"
)


libraryDependencies ++= Seq(
  "com.typesafe.akka" % "akka-actor" % "2.0.1",
  "com.chuusai" %% "shapeless" % "1.2.2",
  "net.fwbrasil" %% "activate-core" % "1.1",
  "net.fwbrasil" %% "activate-jdbc" % "1.1",
  "net.fwbrasil" %% "activate-play" % "1.1",
	"org.scalatest" %% "scalatest" % "1.9.1" % "test"
)

scalaSource in Test <<= baseDirectory(_ /"test")
