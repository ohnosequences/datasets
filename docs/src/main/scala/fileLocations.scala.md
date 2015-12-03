
```scala
package ohnosequences.datasets

import dataSets._
import ohnosequences.cosas.types._
import better.files._

case object fileLocations {

  case class FileDataLocation(val location: File) extends DataLocation[File]

  implicit def fileDataOps[D <: AnyData](data: D): FileDataOps[D] = FileDataOps(data)
  case class FileDataOps[D <: AnyData](val data: D) extends AnyVal {

    def inFile(file: File): D := FileDataLocation = data := FileDataLocation(file)
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