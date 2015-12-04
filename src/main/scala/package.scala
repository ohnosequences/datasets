package ohnosequences

import ohnosequences.cosas._, types._, records._

package object datasets {

  type AnyDataSet = AnyRecordType { type Keys <: AnyProductType { type TypesBound <: AnyData } }
}
