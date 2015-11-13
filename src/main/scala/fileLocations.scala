package ohnosequences.datasets

import ohnosequences.cosas.types._
import java.io.File

case class FileDataLocation(val location: File) extends AnyVal with DataLocation[File]

case object FileDataLocation {

  implicit def fileDataOps[D <: AnyData](data: D): FileDataOps[D] = FileDataOps(data)
}

case class FileDataOps[D <: AnyData](val data: D) extends AnyVal {

  def inFile(file: File): D := FileDataLocation = data := FileDataLocation(file)
}
