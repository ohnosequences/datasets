package ohnosequences.datasets

import dataSets._

trait AnyFileType extends AnyDataType {

  val extension: String

  lazy val suffix: String = s".${extension}"
}

case object fileType {

  trait DefaultFileType extends AnyFileType {

    lazy val extension: String = toString
  }
  
  case object fa    extends DefaultFileType
  case object txt   extends DefaultFileType
  case object gz    extends DefaultFileType
  case object tar   extends DefaultFileType
  case object bed   extends DefaultFileType
  case object info  extends DefaultFileType
  case object gff   extends DefaultFileType
  case object csv   extends DefaultFileType
}

trait AnyFileData extends AnyData {

  type DataType <: AnyFileType

  // NOTE as in the GNU command
  val baseName: String

  // basename + extension
  lazy val label: String = s"${baseName}${dataType.suffix}"
}

abstract class FileData[FT <: AnyFileType](val baseName: String)(val dataType: FT) extends AnyFileData {

  type DataType = FT
}
