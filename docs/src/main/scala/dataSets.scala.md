
```scala
package ohnosequences.datasets

import ohnosequences.cosas._, types._, properties._, typeSets._, records._

case object dataSets {

  trait AnyDataType

  trait AnyData extends AnyType {

    type DataType <: AnyDataType
    val  dataType: DataType

    type Raw = AnyDataLocation
  }

  case object AnyData {

    import fileLocations._
    import better.files._
    implicit def genericParser[D <: AnyData](implicit d: D):
          DenotationParser[D, FileDataLocation, File] =
      new DenotationParser(d, d.label)({ f: File => Some(FileDataLocation(f)) })
  }

  abstract class Data[DT <: AnyDataType](val dataType: DT, val label: String) extends AnyData {

    type DataType = DT
  }

  trait AnyDataLocation {

    type Location
    val  location: Location
  }

  trait DataLocation[L] extends AnyDataLocation { type Location = L }

  // a typeset of Data keys
  trait AnyDataSet {

    type DataSet <: AnyTypeSet //.Of[AnyData]
    val  dataSet: DataSet

    type LocationsAt[L <: AnyDataLocation] <: AnyTypeSet
  }

  // all this nil/cons usual boilerplate
  type DNil = DNil.type
  case object DNil extends AnyDataSet {

    type DataSet = ∅
    val  dataSet = ∅

    type LocationsAt[L <: AnyDataLocation] = ∅
  }

  case class :^:[
    H <: AnyData,
    T <: AnyDataSet
  ](val head: H,
    val tail: T
  )(implicit
    val headIsNew: H ∉ T#DataSet
  ) extends AnyDataSet {

    type DataSet = H :~: T#DataSet
    val  dataSet: DataSet = head :~: (tail.dataSet: T#DataSet)

    type LocationsAt[L <: AnyDataLocation] = (H := L) :~: T#LocationsAt[L]
  }


  implicit def dataSetAtOps[DS <: AnyDataSet](dataSet: DS): DataSetAtOps[DS] = DataSetAtOps(dataSet)
  case class DataSetAtOps[DS <: AnyDataSet](val dataSet: DS) extends AnyVal {

    def :^:[H <: AnyData](data: H)(implicit check: H ∉ DS#DataSet): (H :^: DS) = dataSets.:^:(data, dataSet)
  }

}

```




[test/scala/Datasets.scala]: ../../test/scala/Datasets.scala.md
[test/scala/FileData.scala]: ../../test/scala/FileData.scala.md
[main/scala/s3Locations.scala]: s3Locations.scala.md
[main/scala/fileData.scala]: fileData.scala.md
[main/scala/dataSets.scala]: dataSets.scala.md
[main/scala/fileLocations.scala]: fileLocations.scala.md
[main/scala/illumina.scala]: illumina.scala.md