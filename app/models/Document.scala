package models

import play.api.data._
import play.api.data.Forms._

case class Document(title: String, department: Option[String], link: String)

object Document {

  val form = Form(
    mapping("title" -> nonEmptyText,
      "department" -> optional(text),
      "link" -> text)
      
      (Document.apply)(Document.unapply))
      
}