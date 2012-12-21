name := "Pandora"

version := "0.3"

scalaVersion := "2.9.2"

scalacOptions += "-Ydependent-method-types"

resolvers ++= Seq(
	"Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype OSS Releases" at "http://oss.sonatype.org/content/repositories/releases/",
  "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
)


libraryDependencies ++= Seq(
	"com.typesafe.akka" % "akka-actor" % "2.0.1",
  "com.chuusai" %% "shapeless" % "1.2.2"
)
