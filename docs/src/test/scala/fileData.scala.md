
```scala
package ohnosequences.datasets.test

import org.scalatest.FunSuite
import ohnosequences.datasets._, files._

class FileDataTests extends FunSuite {

  import fileType._

  case object randomData extends FileData("random")(csv)
  case object refGenome  extends FileData("e-coli-reference")(fa)
}

```




[test/scala/fileData.scala]: fileData.scala.md
[test/scala/Datasets.scala]: Datasets.scala.md
[main/scala/illumina/package.scala]: ../../main/scala/illumina/package.scala.md
[main/scala/illumina/reads.scala]: ../../main/scala/illumina/reads.scala.md
[main/scala/fileData.scala]: ../../main/scala/fileData.scala.md
[main/scala/package.scala]: ../../main/scala/package.scala.md
[main/scala/files/files.scala]: ../../main/scala/files/files.scala.md
[main/scala/locations.scala]: ../../main/scala/locations.scala.md
[main/scala/data.scala]: ../../main/scala/data.scala.md