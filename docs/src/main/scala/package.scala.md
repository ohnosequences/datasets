
```scala
package ohnosequences

import ohnosequences.cosas._, types._, records._, klists._

package object datasets {

  type AnyDataSet = AnyRecordType { type Keys <: AnyProductType { type TypesBound <: AnyData } }

  type Resources[R <: AnyDataResource] = *[AnyDenotation { type Value <: R }]
  def  Resources[R <: AnyDataResource]: Resources[R] = *[AnyDenotation { type Value <: R }]
}

```




[main/scala/data.scala]: data.scala.md
[main/scala/fileData.scala]: fileData.scala.md
[main/scala/package.scala]: package.scala.md
[main/scala/resources.scala]: resources.scala.md
[test/scala/Datasets.scala]: ../../test/scala/Datasets.scala.md
[test/scala/fileData.scala]: ../../test/scala/fileData.scala.md