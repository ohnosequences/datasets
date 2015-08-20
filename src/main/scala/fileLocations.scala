package ohnosequences.datasets

import dataSets._
import ohnosequences.cosas.types._
import java.io.File

case object fileLocations {

  case class FileDataLocation(val location: File)        extends DataLocation[File]
  class FileLocations[DS <: AnyDataSet](val dataSet: DS)
    extends DataSetLocations[FileDataLocation] { type DataSet = DS }

  implicit def fileDataOps[D <: AnyData](data: D): FileDataOps[D] = FileDataOps(data)
  case class FileDataOps[D <: AnyData](val data: D) extends AnyVal {

    def inFile(file: File): D := FileDataLocation = data := FileDataLocation(file)
  }
}
