name := "free-monad-example"

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.3")

scalaVersion := "2.11.8"

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "7.2.4",
  "org.scalaz" %% "scalaz-concurrent" % "7.2.4",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test"
)
