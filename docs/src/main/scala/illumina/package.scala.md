
```scala
package ohnosequences.datasets

package object illumina {

  type SingleEndType = singleEndType.type
  val SingleEndType: SingleEndType = singleEndType
  
  type PairedEndType = pairedEndType.type
  val PairedEndType: PairedEndType = pairedEndType
}

```




[test/scala/fileData.scala]: ../../../test/scala/fileData.scala.md
[test/scala/Datasets.scala]: ../../../test/scala/Datasets.scala.md
[main/scala/illumina/package.scala]: package.scala.md
[main/scala/illumina/reads.scala]: reads.scala.md
[main/scala/fileData.scala]: ../fileData.scala.md
[main/scala/package.scala]: ../package.scala.md
[main/scala/files/files.scala]: ../files/files.scala.md
[main/scala/locations.scala]: ../locations.scala.md
[main/scala/data.scala]: ../data.scala.md