
```scala
package ohnosequences.datasets

package object illumina {

  type SingleEndType = singleEndType.type
  val SingleEndType: SingleEndType = singleEndType

  type PairedEndType = pairedEndType.type
  val PairedEndType: PairedEndType = pairedEndType
}

```




[main/scala/data.scala]: ../data.scala.md
[main/scala/fileData.scala]: ../fileData.scala.md
[main/scala/illumina/package.scala]: package.scala.md
[main/scala/illumina/reads.scala]: reads.scala.md
[main/scala/package.scala]: ../package.scala.md
[main/scala/resources.scala]: ../resources.scala.md
[test/scala/Datasets.scala]: ../../../test/scala/Datasets.scala.md
[test/scala/fileData.scala]: ../../../test/scala/fileData.scala.md