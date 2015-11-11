package ohnosequences.datasets

import ohnosequences.cosas._, types._, fns._, klists._, records._

case object dataSets {

  trait AnyDataType

  trait AnyData extends AnyType {

    type DataType <: AnyDataType
    val  dataType: DataType

    // this acts here as a bound
    type Raw = AnyDataLocation
  }

  case object AnyData {

    import fileLocations._
    import java.io.File
    implicit def genericParser[D <: AnyData](implicit d: D):
          DenotationParser[D, FileDataLocation, File] =
      new DenotationParser(d, d.label)({ f: File => Some(FileDataLocation(f)) })
  }

  abstract class Data[DT <: AnyDataType](val dataType: DT, val label: String) extends AnyData {

    type DataType = DT
  }

  type AnyDataSet = AnyRecordType { type Keys <: AnyProductType { type Bound <: AnyData } }

  abstract class DataSet[
    data <: AnyProductType { type Types <: AnyKList { type Bound <: AnyData } }
  ](val d: data)(implicit
    noDup: NoDuplicates[data#Types]
  ) extends RecordType[data](d)

  trait AnyDataLocation extends Any {

    type Location
    def  location: Location
  }

  trait DataLocation[L] extends Any with AnyDataLocation { type Location = L }

  // a typeset of Data keys
  // trait AnyDataSet extends AnyRecordType {
  //
  //   type Keys <: AnyProductType { type Bound <: AnyData }
  //   type DataSet <: AnyTypeSet //.Of[AnyData]
  //   val  dataSet: DataSet
  //
  //   type LocationsAt[L <: AnyDataLocation] <: AnyTypeSet
  // }
  //
  // // all this nil/cons usual boilerplate
  // type DNil = DNil.type
  // case object DNil extends AnyDataSet {
  //
  //   type DataSet = ∅
  //   val  dataSet = ∅
  //
  //   type LocationsAt[L <: AnyDataLocation] = ∅
  // }
  //
  // case class :^:[
  //   H <: AnyData,
  //   T <: AnyDataSet
  // ](val head: H,
  //   val tail: T
  // )(implicit
  //   val headIsNew: H ∉ T#DataSet
  // ) extends AnyDataSet {
  //
  //   type DataSet = H :~: T#DataSet
  //   val  dataSet: DataSet = head :~: (tail.dataSet: T#DataSet)
  //
  //   type LocationsAt[L <: AnyDataLocation] = (H := L) :~: T#LocationsAt[L]
  // }
  //
  //
  // implicit def dataSetAtOps[DS <: AnyDataSet](dataSet: DS): DataSetAtOps[DS] = DataSetAtOps(dataSet)
  // case class DataSetAtOps[DS <: AnyDataSet](val dataSet: DS) extends AnyVal {
  //
  //   def :^:[H <: AnyData](data: H)(implicit check: H ∉ DS#DataSet): (H :^: DS) = dataSets.:^:(data, dataSet)
  // }

}
