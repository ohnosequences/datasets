name          := "datasets"
organization  := "ohnosequences"
description   := ""

bucketSuffix  := "era7.com"

libraryDependencies ++= Seq(
  "ohnosequences"        %% "cosas"            % "0.8.0",
  "ohnosequences"        %% "aws-scala-tools"  % "0.18.0",
  "com.github.pathikrit" %% "better-files"     % "2.13.0",
  "org.scalatest"        %% "scalatest"        % "2.2.6" % Test
)
