
```scala
package ohnosequences.datasets

import dataSets._
import ohnosequences.cosas.types._
import ohnosequences.awstools.s3._

case object s3Locations {

  case class S3DataLocation(val location: AnyS3Address) extends DataLocation[AnyS3Address]

  implicit def s3DataOps[D <: AnyData](data: D): S3DataOps[D] = S3DataOps(data)
  case class S3DataOps[D <: AnyData](val data: D) extends AnyVal {

    def inS3(addr: AnyS3Address): D := S3DataLocation = data := S3DataLocation(addr)
  }
}

```




[main/scala/dataSets.scala]: dataSets.scala.md
[main/scala/fileData.scala]: fileData.scala.md
[main/scala/fileLocations.scala]: fileLocations.scala.md
[main/scala/illumina.scala]: illumina.scala.md
[main/scala/s3Locations.scala]: s3Locations.scala.md
[test/scala/Datasets.scala]: ../../test/scala/Datasets.scala.md
[test/scala/FileData.scala]: ../../test/scala/FileData.scala.md