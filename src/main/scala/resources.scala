package ohnosequences.datasets

import ohnosequences.cosas._, types._
import better.files._
import ohnosequences.awstools.s3._

sealed trait AnyDataResource extends Any {

  type Resource
  def  resource: Resource
}

trait DataResource[R]  extends Any with AnyDataResource { type Resource = R }


sealed trait AnyLocalResource  extends Any with AnyDataResource

case class FileResource(val resource: File)       extends AnyVal with AnyLocalResource with DataResource[File]


sealed trait AnyRemoteResource extends Any with AnyDataResource

case class S3Resource(val resource: AnyS3Address) extends AnyVal with AnyRemoteResource with DataResource[AnyS3Address]
case class MessageResource(val resource: String)  extends AnyVal with AnyRemoteResource with DataResource[String]
