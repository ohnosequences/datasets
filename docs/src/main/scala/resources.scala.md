
```scala
package ohnosequences.datasets

import ohnosequences.cosas._, types._
import better.files._
import ohnosequences.awstools.s3._

sealed trait AnyDataResource extends Any {

  type Resource
  def  resource: Resource
}

trait DataResource[R]  extends Any with AnyDataResource { type Resource = R }


sealed trait AnyLocalResource  extends Any with AnyDataResource

case class FileResource(val resource: File)       extends AnyVal with AnyLocalResource with DataResource[File]


sealed trait AnyRemoteResource extends Any with AnyDataResource

case class S3Resource(val resource: AnyS3Address) extends AnyVal with AnyRemoteResource with DataResource[AnyS3Address]
case class MessageResource(val resource: String)  extends AnyVal with AnyRemoteResource with DataResource[String]

```




[main/scala/data.scala]: data.scala.md
[main/scala/fileData.scala]: fileData.scala.md
[main/scala/illumina/package.scala]: illumina/package.scala.md
[main/scala/illumina/reads.scala]: illumina/reads.scala.md
[main/scala/package.scala]: package.scala.md
[main/scala/resources.scala]: resources.scala.md
[test/scala/Datasets.scala]: ../../test/scala/Datasets.scala.md
[test/scala/fileData.scala]: ../../test/scala/fileData.scala.md