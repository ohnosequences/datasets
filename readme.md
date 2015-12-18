### Datasets

[![](https://travis-ci.org/ohnosequences/datasets.svg?branch=master)](https://travis-ci.org/ohnosequences/datasets)
[![](https://img.shields.io/codacy/c297af178893452f8452ace696540270.svg)](https://www.codacy.com/app/era7/datasets)
[![](https://img.shields.io/github/release/ohnosequences/datasets.svg)](https://github.com/ohnosequences/datasets/releases/latest)
[![](https://img.shields.io/badge/license-AGPLv3-blue.svg)](https://tldrlegal.com/license/gnu-affero-general-public-license-v3-%28agpl-3.0%29)
[![](https://img.shields.io/badge/contact-gitter_chat-dd1054.svg)](https://gitter.im/ohnosequences/datasets)

This little Scala library provides convenient abstractions for working with datasets. It is based on the [cosas](https://github.com/ohnosequences/cosas) library and is primarily used in the [loquat](https://github.com/ohnosequences/loquat) project.

- `AnyData` is just a [Type](https://github.com/ohnosequences/cosas/blob/master/docs/src/main/scala/cosas/types/types.scala.md) with a bound on it's `Raw` representation: it has to be a `AnyDataResource`

- `AnyDataResource` can be either local or remote:
    + Local ones are represented by files (`FileResrouce`)
    + Remote ones are either S3 objects (`S3Resource`) or (string-containing) messages (`MessageResource`)

- `AnyDataSet` is basically just an alias for a [Record](https://github.com/ohnosequences/cosas/blob/master/docs/src/main/scala/cosas/records/recordTypes.scala.md) that consists of `AnyData` objects

There are also some types related to the Illumina reads data (which will be probably separated at some point).
