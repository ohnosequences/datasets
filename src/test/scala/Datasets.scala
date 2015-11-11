package ohnosequences.datasets.test

import org.scalatest.FunSuite

import ohnosequences.datasets._, dataSets._, illumina._, s3Locations._, fileLocations._
import java.io.File
import ohnosequences.awstools.s3._
import ohnosequences.cosas._, types._, klists._, records._, fns._

class stupidDataTests extends FunSuite {

  case object buh extends AnyDataType

  case object unBuh extends Data(buh, "un buh")
  case object otroBuh extends Data(buh, "otro buh")


  case object variosBuhs extends DataSet(unBuh :×: otroBuh :×: In[AnyData])
  // case object variosBuhsMal extends DataSet(unBuh :×: otroBuh :×: In[AnyType])

  variosBuhs :=
    (unBuh := FileDataLocation(new File("."))) ::
    (otroBuh := FileDataLocation(new File("."))) :: *[AnyDenotation { type Value <: FileDataLocation }]

}



class IlluminaDataTests extends FunSuite {

  val readsType = illumina.PairedEnd(bp75, unknownInsertSize)

  // object sample extends PairedEndReads(
  //   // looks like I can create this inline here
  //   new reads.PairedEnd1Fastq(readsType, "reads1"),
  //   new reads.PairedEnd2Fastq(readsType, "reads2")
  // )
  //
  // object sampleAtS3 extends S3Locations(sample.dataSet)
  //
  // val z: ValueOf[sampleAtS3.type] = sampleAtS3 := (
  //   (sample.reads1 atS3 ObjectAddress("hola", "caracola"))      :~:
  //   (sample.reads2 atS3 ObjectAddress("hola", "otra-caracola")) :~: ∅
  // )
  //
  // sealed trait sampleTag { lazy val tag = toString }
  // case object control extends sampleTag
  // case object happy   extends sampleTag
  // case object funny   extends sampleTag
  // // ...
  //
  // class Sample[RT <:  AnyReadsType { type EndType = pairedEndType }, ST <: sampleTag](
  //   val readsType: RT,
  //   val st: ST
  // ) {
  //
  //   case object reads1 extends reads.PairedEnd1Fastq(readsType, s"{st.tag}/whatever1")
  //   case object reads2 extends reads.PairedEnd2Fastq(readsType, s"{st.tag}/whatever2")
  // }
  //
  // val controlReads = new Sample(readsType, control)
  //
  // val controlReadsDataset = controlReads.reads1 :^: controlReads.reads2 :^: DNil
  //
  // object locations extends S3Locations(controlReadsDataset)
  //
  // val zz =locations := (
  //   (controlReads.reads1 atS3 ObjectAddress("hola", "caracola"))      :~:
  //   (controlReads.reads2 atS3 ObjectAddress("hola", "otra-caracola")) :~: ∅
  // )
}
