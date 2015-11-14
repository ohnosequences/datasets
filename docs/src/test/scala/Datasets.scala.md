
```scala
package ohnosequences.datasets.test

import org.scalatest.FunSuite

import ohnosequences.datasets._, dataSets._, illumina._, s3Locations._
import ohnosequences.awstools.s3.S3Object
import ohnosequences.cosas._, types._, typeSets._

class IlluminaDataTests extends FunSuite {

  val readsType = illumina.PairedEnd(bp75, unknownInsertSize)

  object sample extends PairedEndReads(
    // looks like I can create this inline here
    new reads.PairedEnd1Fastq(readsType, "reads1"),
    new reads.PairedEnd2Fastq(readsType, "reads2")
  )

  // object sampleAtS3 extends S3Locations(sample.dataSet)
  //
  // val z: ValueOf[sampleAtS3.type] = sampleAtS3 := (
  //   (sample.reads1 atS3 ObjectAddress("hola", "caracola"))      :~:
  //   (sample.reads2 atS3 ObjectAddress("hola", "otra-caracola")) :~: ∅
  // )

  sealed trait sampleTag { lazy val tag = toString }
  case object control extends sampleTag
  case object happy   extends sampleTag
  case object funny   extends sampleTag
  // ...

  case class Sample[RT <:  AnyReadsType { type EndType = pairedEndType }, ST <: sampleTag](
    val readsType: RT,
    val st: ST
  )
  {

    object reads1 extends reads.PairedEnd1Fastq(readsType, s"{st.tag}/whatever1")
    object reads2 extends reads.PairedEnd2Fastq(readsType, s"{st.tag}/whatever2")
  }

  val controlReads = new Sample(readsType, control)

  val controlReadsDataset = controlReads.reads1 :^: controlReads.reads2 :^: DNil

  // object locations extends S3Locations(controlReadsDataset)
  //
  // val zz =locations := (
  //   (controlReads.reads1 atS3 ObjectAddress("hola", "caracola"))      :~:
  //   (controlReads.reads2 atS3 ObjectAddress("hola", "otra-caracola")) :~: ∅
  // )
}

```




[test/scala/Datasets.scala]: Datasets.scala.md
[test/scala/FileData.scala]: FileData.scala.md
[main/scala/s3Locations.scala]: ../../main/scala/s3Locations.scala.md
[main/scala/fileData.scala]: ../../main/scala/fileData.scala.md
[main/scala/dataSets.scala]: ../../main/scala/dataSets.scala.md
[main/scala/fileLocations.scala]: ../../main/scala/fileLocations.scala.md
[main/scala/illumina.scala]: ../../main/scala/illumina.scala.md