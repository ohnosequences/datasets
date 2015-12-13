
```scala
package ohnosequences.datasets

import ohnosequences.cosas._, types._, fns._, klists._, records._
import better.files._

trait AnyDataType

trait AnyData extends AnyType {

  type DataType <: AnyDataType
  val  dataType: DataType

  // this acts here as a bound
  type Raw = AnyDataLocation
}

case object AnyData {

  implicit def genericParser[D <: AnyData](implicit d: D):
        DenotationParser[D, FileDataLocation, File] =
    new DenotationParser(d, d.label)({ f: File => Some(FileDataLocation(f)) })
}

abstract class Data[DT <: AnyDataType](val dataType: DT, val label: String) extends AnyData {

  type DataType = DT
}

abstract class DataSet[
  data <: AnyProductType { type Types <: AnyKList { type Bound <: AnyData } }
](val d: data)(implicit
  proof: noDuplicates isTrueOn data#Types
) extends RecordType[data](d)

```




[test/scala/fileData.scala]: ../../test/scala/fileData.scala.md
[test/scala/Datasets.scala]: ../../test/scala/Datasets.scala.md
[main/scala/illumina/package.scala]: illumina/package.scala.md
[main/scala/illumina/reads.scala]: illumina/reads.scala.md
[main/scala/fileData.scala]: fileData.scala.md
[main/scala/package.scala]: package.scala.md
[main/scala/files/files.scala]: files/files.scala.md
[main/scala/locations.scala]: locations.scala.md
[main/scala/data.scala]: data.scala.md