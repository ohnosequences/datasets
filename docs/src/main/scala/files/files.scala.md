
```scala
package ohnosequences.datasets.files

import ohnosequences.datasets._

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
  case object html  extends DefaultFileType
  case object bt2   extends DefaultFileType // bowtie index files
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

```




[test/scala/fileData.scala]: ../../../test/scala/fileData.scala.md
[test/scala/Datasets.scala]: ../../../test/scala/Datasets.scala.md
[main/scala/illumina/package.scala]: ../illumina/package.scala.md
[main/scala/illumina/reads.scala]: ../illumina/reads.scala.md
[main/scala/fileData.scala]: ../fileData.scala.md
[main/scala/package.scala]: ../package.scala.md
[main/scala/files/files.scala]: files.scala.md
[main/scala/locations.scala]: ../locations.scala.md
[main/scala/data.scala]: ../data.scala.md