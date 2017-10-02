package ohnosequences.datasets.test

import org.scalatest.FunSuite
import ohnosequences.cosas._, types._
import ohnosequences.datasets._
import java.io.File

class stupidDataTests extends FunSuite {

  case object unBuh extends Data("un buh")
  case object otroBuh extends Data("otro buh")

  case object variosBuhs extends DataSet(unBuh :×: otroBuh :×: |[AnyData])

  val denotation = variosBuhs :=
    unBuh(new File(".")) ::
    otroBuh(new File(".")) ::
    Resources[FileResource]
}
