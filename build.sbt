Nice.scalaProject

name          := "datasets"
organization  := "ohnosequences"
description   := ""

bucketSuffix  := "era7.com"

libraryDependencies ++= Seq(
  "ohnosequences" %% "cosas"            % "0.7.0",
  "ohnosequences" %% "aws-scala-tools"  % "0.13.2",
  "org.scalatest" %% "scalatest"        % "2.2.5" % Test
)
