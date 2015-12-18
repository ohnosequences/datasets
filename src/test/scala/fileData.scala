package ohnosequences.datasets.test

import org.scalatest.FunSuite
import ohnosequences.datasets._

class FileDataTests extends FunSuite {

  case object randomData extends FileData("random")("csv")
  case object refGenome  extends FileData("e-coli-reference")("fa")
}
