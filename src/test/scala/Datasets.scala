package ohnosequences.datasets.test

import org.scalatest.FunSuite

import ohnosequences.datasets._, dataSets._, illumina._, s3Locations._
import ohnosequences.awstools.s3.ObjectAddress
import ohnosequences.cosas._, types._, typeSets._

class IlluminaDataTests extends FunSuite {

  val readsType = illumina.PairedEnd(bp75, unknownInsertSize)

  object sample extends PairedEndReads(
    new reads.PairedEnd1Fastq(readsType, "reads1"),
    new reads.PairedEnd2Fastq(readsType, "reads2")
  )

  object sampleAtS3 extends S3Locations(sample.dataSet)

  val z: ValueOf[sampleAtS3.type] = sampleAtS3 := (
    (sample.reads1 atS3 ObjectAddress("hola", "caracola"))      :~:
    (sample.reads2 atS3 ObjectAddress("hola", "otra-caracola")) :~: ∅
  )
}
