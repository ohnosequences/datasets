
```scala
package ohnosequences.datasets.test

import org.scalatest.FunSuite
import ohnosequences.datasets._

class FileDataTests extends FunSuite {

  case object randomData extends FileData("random")("csv")
  case object refGenome  extends FileData("e-coli-reference")("fa")
}

```




[main/scala/data.scala]: ../../main/scala/data.scala.md
[main/scala/fileData.scala]: ../../main/scala/fileData.scala.md
[main/scala/illumina/package.scala]: ../../main/scala/illumina/package.scala.md
[main/scala/illumina/reads.scala]: ../../main/scala/illumina/reads.scala.md
[main/scala/package.scala]: ../../main/scala/package.scala.md
[main/scala/resources.scala]: ../../main/scala/resources.scala.md
[test/scala/Datasets.scala]: Datasets.scala.md
[test/scala/fileData.scala]: fileData.scala.md