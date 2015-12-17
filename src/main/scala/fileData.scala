package ohnosequences.datasets

trait AnyFileData extends AnyData {

  val baseName: String
  val extension: String

  lazy val label: String = s"${baseName}.${extension}"
}

abstract class FileData(base: String)(ext: String) extends AnyFileData {

  val baseName = base.stripSuffix(".")
  val extension = ext.stripPrefix(".")
}
