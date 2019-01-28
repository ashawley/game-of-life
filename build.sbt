autoScalaLibrary := false

name := "game-of-life"

version := "0.1-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.junit.jupiter" % "junit-jupiter-engine" % "5.1.0" % "test",
  "org.junit.jupiter" % "junit-jupiter-api" % "5.1.0" % "test",
  "net.aichler" % "jupiter-interface" % JupiterKeys.jupiterVersion.value % "test"
)
