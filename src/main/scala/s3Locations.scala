package ohnosequences.datasets

import ohnosequences.cosas._, types._
import ohnosequences.awstools.s3._

case class S3DataLocation(val location: AnyS3Address) extends AnyVal with DataLocation[AnyS3Address]

case object S3DataLocation {

  implicit def s3DataOps[D <: AnyData](data: D): S3DataOps[D] = S3DataOps(data)
}

case class S3DataOps[D <: AnyData](val data: D) extends AnyVal {

  def inS3(addr: AnyS3Address): D := S3DataLocation = data := S3DataLocation(addr)
}
