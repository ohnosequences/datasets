name          := "datasets"
organization  := "ohnosequences"
description   := ""

bucketSuffix  := "era7.com"

libraryDependencies ++= Seq(
  "ohnosequences" %% "cosas"           % "0.9.0",
  "ohnosequences" %% "aws-scala-tools" % "0.19.0",
  "org.scalatest" %% "scalatest"       % "3.0.4" % Test
)
