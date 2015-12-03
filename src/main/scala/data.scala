package ohnosequences.datasets

import ohnosequences.cosas._, types._, fns._, klists._, records._

trait AnyDataType

trait AnyData extends AnyType {

  type DataType <: AnyDataType
  val  dataType: DataType

  // this acts here as a bound
  type Raw = AnyDataLocation
}

case object AnyData {

  import java.io.File
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
  noDup: NoDuplicates[data#Types]
) extends RecordType[data](d)
