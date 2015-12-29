package ohnosequences.datasets

import ohnosequences.cosas._, types._, fns._, klists._, records._
import ohnosequences.awstools.s3._
import better.files._

trait AnyData extends AnyType {

  // this acts here as a bound
  type Raw = AnyDataResource
}

case object AnyData {
  implicit def dataOps[D <: AnyData](data: D): DataOps[D] = DataOps(data)

  // TODO: remove this?
  // implicit def genericParser[D <: AnyData](implicit d: D):
  //       DenotationParser[D, FileResource, File] =
  //   new DenotationParser(d, d.label)({ f: File => Some(FileResource(f)) })
}

abstract class Data(val label: String) extends AnyData

/* Using various apply methods we can construct denotations of the data with distinguishable resources */
case class DataOps[D <: AnyData](val data: D) extends AnyVal {

  def apply(file: File):         D := FileResource    = data := FileResource(file)
  def apply(addr: AnyS3Address): D := S3Resource      = data := S3Resource(addr)
  def apply(msg: String):        D := MessageResource = data := MessageResource(msg)
}

abstract class DataSet[
  data <: AnyProductType { type Types <: AnyKList { type Bound <: AnyData } }
](val d: data)(implicit
  proof: noDuplicates isTrueOn data#Types
) extends RecordType[data](d)
