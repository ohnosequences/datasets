package ohnosequences.datasets.test

import org.scalatest.FunSuite
import ohnosequences.datasets._, files._

class FileDataTests extends FunSuite {

  import fileType._

  case object randomData extends FileData("random")(csv)
  case object refGenome  extends FileData("e-coli-reference")(fa)
}
