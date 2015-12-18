
```scala
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

```




[main/scala/data.scala]: data.scala.md
[main/scala/fileData.scala]: fileData.scala.md
[main/scala/illumina/package.scala]: illumina/package.scala.md
[main/scala/illumina/reads.scala]: illumina/reads.scala.md
[main/scala/package.scala]: package.scala.md
[main/scala/resources.scala]: resources.scala.md
[test/scala/Datasets.scala]: ../../test/scala/Datasets.scala.md
[test/scala/fileData.scala]: ../../test/scala/fileData.scala.md