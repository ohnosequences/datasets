package ohnosequences.datasets.test

import org.scalatest.FunSuite

import ohnosequences.datasets._, dataSets._, s3Locations._
import ohnosequences.awstools.s3.S3Object
import ohnosequences.cosas._, types._, typeSets._


class FileDataTests extends FunSuite {

  import fileType._
  
  case object randomData extends FileData("random")(csv)
  case object refGenome  extends FileData("e-coli-reference")(fa)
}
