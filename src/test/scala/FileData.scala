package ohnosequences.datasets.test

import org.scalatest.FunSuite

import ohnosequences.datasets._, dataSets._, s3Locations._
import ohnosequences.awstools.s3.S3Object
import ohnosequences.cosas._, types._, typeSets._


class FileDataTests extends FunSuite {

  case object randomData extends FileData("random")(fileType.csv)
  case object refGenome  extends FileData("e-coli-reference")(fileType.fa)
}
