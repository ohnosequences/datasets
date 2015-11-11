Nice.scalaProject

name          := "datasets"
organization  := "ohnosequences"
description   := ""

bucketSuffix  := "era7.com"

libraryDependencies ++= Seq(
  "ohnosequences" %% "cosas"            % "0.7.1",
  "ohnosequences" %% "aws-scala-tools"  % "0.15.0-amis-SNAPSHOT",
  "org.scalatest" %% "scalatest"        % "2.2.5" % Test
)
