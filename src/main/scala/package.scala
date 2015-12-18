package ohnosequences

import ohnosequences.cosas._, types._, records._, klists._

package object datasets {

  type AnyDataSet = AnyRecordType { type Keys <: AnyProductType { type TypesBound <: AnyData } }

  type Resources[R <: AnyDataResource] = *[AnyDenotation { type Value <: R }]
  def  Resources[R <: AnyDataResource]: Resources[R] = *[AnyDenotation { type Value <: R }]
}
