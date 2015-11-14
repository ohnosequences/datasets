
```scala
package ohnosequences.datasets.test

import org.scalatest.FunSuite

import ohnosequences.datasets._, dataSets._, s3Locations._
import ohnosequences.awstools.s3.S3Object
import ohnosequences.cosas._, types._, typeSets._


class FileDataTests extends FunSuite {

  import fileType._
  
  case object randomData extends FileData("random")(csv)
  case object refGenome  extends FileData("e-coli-reference")(fa)
}

```




[test/scala/Datasets.scala]: Datasets.scala.md
[test/scala/FileData.scala]: FileData.scala.md
[main/scala/s3Locations.scala]: ../../main/scala/s3Locations.scala.md
[main/scala/fileData.scala]: ../../main/scala/fileData.scala.md
[main/scala/dataSets.scala]: ../../main/scala/dataSets.scala.md
[main/scala/fileLocations.scala]: ../../main/scala/fileLocations.scala.md
[main/scala/illumina.scala]: ../../main/scala/illumina.scala.md