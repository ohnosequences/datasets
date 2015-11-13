package ohnosequences.datasets

case object illumina {

  trait AnyReadsType extends AnyDataType {

    type InsertSize <: AnyInsertSize
    val  insertSize: InsertSize

    type EndType <: AnyEndType
    val  endType: EndType

    type Length <: AnyLength
    val  length: Length

    lazy val label: String = s"Illumina.${endType}.${length}.${length}"
  }

  abstract class ReadsType[
    InsrtSz <: AnyInsertSize,
    EndTp   <: AnyEndType,
    Lngth   <: AnyLength
  ](
    val endType: EndTp,
    val length: Lngth,
    val insertSize: InsrtSz
  )
  extends AnyReadsType {

    type InsertSize = InsrtSz
    type Length     = Lngth
    type EndType    = EndTp
  }

  // Illumina insert size
  sealed trait AnyInsertSize { val size: Option[Int] }
  case object unknownInsertSize         extends AnyInsertSize { val size = None     }
  case class  InsertSize(val s: Int)    extends AnyInsertSize { val size = Some(s)  }

  // Illumina (runs?) are either single-end or paired-end
  sealed trait AnyEndType
  case object singleEndType extends AnyEndType; type singleEndType = singleEndType.type
  case object pairedEndType extends AnyEndType; type pairedEndType = pairedEndType.type

  sealed trait AnyLength { val length: Int }
  class Length(val length: Int) extends AnyLength
  case object bp300 extends Length(300)
  case object bp250 extends Length(250)
  case object bp150 extends Length(150)
  case object bp100 extends Length(100)
  case object bp75  extends Length(75)
  case object bp50  extends Length(50)

  case class SingleEnd[
    InsrtSz <: AnyInsertSize,
    Lngth <: AnyLength
  ](val l: Lngth, val is: InsrtSz)
    extends ReadsType(singleEndType, l, is)

  case class PairedEnd[
    InsrtSz <: AnyInsertSize,
    Lngth <: AnyLength
  ](val l: Lngth, val is: InsrtSz)
    extends ReadsType(pairedEndType, l, is)


  /*
    ### Illumina reads
  */
  case object reads {

    trait AnySingleEndFastq extends AnyData {

      type DataType <: AnyReadsType { type EndType = singleEndType }
    }
    class SingleEndFastq[DtTyp <: AnyReadsType { type EndType = singleEndType }](
      val dataType: DtTyp,
      val label: String
    )
    extends AnySingleEndFastq { type DataType = DtTyp }


    trait AnyPairedEnd1Fastq extends AnyData {

      type DataType <: AnyReadsType { type EndType = pairedEndType }
    }
    trait AnyPairedEnd2Fastq extends AnyData {

      type DataType <: AnyReadsType { type EndType = pairedEndType }
    }

    class PairedEnd1Fastq[DtTyp <: AnyReadsType { type EndType = pairedEndType }](
      val dataType: DtTyp,
      val label: String
    )
    extends AnyPairedEnd1Fastq { type DataType = DtTyp }

    class PairedEnd2Fastq[DtTyp <: AnyReadsType { type EndType = pairedEndType }](
      val dataType: DtTyp,
      val label: String
    )
    extends AnyPairedEnd2Fastq { type DataType = DtTyp }

  }

  // TODO if there's any use of this, it should go into some AnyDataType
  trait AnySequencingTechnology
  case object Illumina extends AnySequencingTechnology

  sealed trait AnyIlluminaMachine
  case object MiSeq       extends AnyIlluminaMachine
  case object MiSeqDx     extends AnyIlluminaMachine
  case object MiSeqFGx    extends AnyIlluminaMachine
  case object NextSeq500  extends AnyIlluminaMachine
  case object HiSeq2500   extends AnyIlluminaMachine
  case object HiSeq3000   extends AnyIlluminaMachine
  case object HiSeq4000   extends AnyIlluminaMachine
  case object HiSeqXFive  extends AnyIlluminaMachine
  case object HiSeqXTen   extends AnyIlluminaMachine

  // useless as of now
  trait AnySequencingRun {

    type Technology <: AnySequencingTechnology
    val technology: Technology
    // TODO provider, whatever
  }
}
