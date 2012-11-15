package models

import play.api.data._
import play.api.data.Forms._

/**
 * A document is the basic class which is inserted inside
 * the database. It consists of all basic features to search
 * for documents
 * <ul>
 *   <li>Name</li>
 *   <li>Department</li>
 *   <li>Link</li>
 *   <li>Tags</li>
 * </ul>
 */
case class Document(title: String, department: Option[String], link: String, tags: String) {
  
  def tagsAsList = tags.split(",").toList.map(_.trim)
}

object Document {

  val form = Form(
    mapping("title" -> nonEmptyText,
      "department" -> optional(text),
      "link" -> text,
      "tags" -> text)
      
      (Document.apply)(Document.unapply))
      
}