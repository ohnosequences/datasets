package ohnosequences.datasets

import ohnosequences.cosas._, types._, properties._, typeSets._, records._

case object dataSets {

  /* ### Data types

     Reads, statistics, annotations, etc.
  */
  trait AnyDataType extends AnyType

  trait AnyData extends AnyType {

    type DataType <: AnyDataType
    val  dataType: DataType

    // this acts here as a bound
    type Raw = AnyDataLocation
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


  // this is something similar to a record of locations for the given data set
  trait AnyDataSetLocations extends AnyType {

    type DataSet <: AnyDataSet
    val  dataSet: DataSet

    type LocationType <: AnyDataLocation

    type Raw = DataSet#LocationsAt[LocationType]

    lazy val label: String = this.toString
  }

  // this fixes only the location type
  abstract class DataSetLocations[LT <: AnyDataLocation]
    extends AnyDataSetLocations { type LocationType = LT }
}