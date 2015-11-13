package ohnosequences.datasets

import ohnosequences.cosas._, types._
import java.io.File
import ohnosequences.awstools.s3._

sealed trait AnyDataLocation extends Any {

  type Location
  def  location: Location
}

trait DataLocation[L] extends Any with AnyDataLocation { type Location = L }

case class FileDataLocation(val location: File) extends AnyVal with DataLocation[File]

case object FileDataLocation {

  implicit def fileDataOps[D <: AnyData](data: D): FileDataOps[D] = FileDataOps(data)
}

case class FileDataOps[D <: AnyData](val data: D) extends AnyVal {

  def inFile(file: File): D := FileDataLocation = data := FileDataLocation(file)
}

case class S3DataLocation(val location: AnyS3Address) extends AnyVal with DataLocation[AnyS3Address]

case object S3DataLocation {

  implicit def s3DataOps[D <: AnyData](data: D): S3DataOps[D] = S3DataOps(data)
}

case class S3DataOps[D <: AnyData](val data: D) extends AnyVal {

  def inS3(addr: AnyS3Address): D := S3DataLocation = data := S3DataLocation(addr)
}
