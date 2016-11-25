
```scala
package ohnosequences.datasets.test

import org.scalatest.FunSuite
import ohnosequences.awstools.s3._
import ohnosequences.cosas._, types._, klists._, records._, fns._
import ohnosequences.datasets._
import java.io.File

class stupidDataTests extends FunSuite {

  case object unBuh extends Data("un buh")
  case object otroBuh extends Data("otro buh")

  case object variosBuhs extends DataSet(unBuh :×: otroBuh :×: |[AnyData])

  val denotation = variosBuhs :=
    unBuh(new File(".")) ::
    otroBuh(new File(".")) ::
    Resources[FileResource]
}

```




[main/scala/data.scala]: ../../main/scala/data.scala.md
[main/scala/fileData.scala]: ../../main/scala/fileData.scala.md
[main/scala/package.scala]: ../../main/scala/package.scala.md
[main/scala/resources.scala]: ../../main/scala/resources.scala.md
[test/scala/Datasets.scala]: Datasets.scala.md
[test/scala/fileData.scala]: fileData.scala.md