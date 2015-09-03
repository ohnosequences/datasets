
```scala
package ohnosequences.datasets

import dataSets._
import ohnosequences.cosas.types._
import ohnosequences.awstools.s3.ObjectAddress

case object s3Locations {

  case class S3DataLocation(val location: ObjectAddress) extends DataLocation[ObjectAddress]
  class S3Locations[DS <: AnyDataSet](val dataSet: DS)
    extends DataSetLocations[S3DataLocation] { type DataSet = DS }

  implicit def s3DataOps[D <: AnyData](data: D): S3DataOps[D] = S3DataOps(data)
  case class S3DataOps[D <: AnyData](val data: D) extends AnyVal {

    def atS3(addr: ObjectAddress): D := S3DataLocation = data := S3DataLocation(addr)
  }
}

```




[test/scala/Datasets.scala]: ../../test/scala/Datasets.scala.md
[main/scala/s3Locations.scala]: s3Locations.scala.md
[main/scala/dataSets.scala]: dataSets.scala.md
[main/scala/fileLocations.scala]: fileLocations.scala.md
[main/scala/illumina.scala]: illumina.scala.md