package ohnosequences.datasets.test

import org.scalatest.FunSuite

import better.files._
import ohnosequences.awstools.s3._
import ohnosequences.cosas._, types._, klists._, records._, fns._

import ohnosequences.datasets._

class stupidDataTests extends FunSuite {

  case object unBuh extends Data("un buh")
  case object otroBuh extends Data("otro buh")

  case object variosBuhs extends DataSet(unBuh :×: otroBuh :×: |[AnyData])

  val denotation = variosBuhs :=
    unBuh(File(".")) ::
    otroBuh(File(".")) ::
    Resources[FileResource]
}
