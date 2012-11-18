package models

import play.api.data._
import play.api.data.Forms._
import play.api.Play.current
import java.util.Date
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._



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
case class Document(id: ObjectId, title: String, department: Option[String], link: String, tags: String) {
  
  def tagsAsList = tags.split(",").toList.map(_.trim)
}

object Document {

  def wrap(title: String , department: Option[String], link: String, tags: String): Document = {
    Document(new ObjectId,title, department, link, tags)
  }
  
  def unwrap(d: Document) = {
    Some(d.title, d.department, d.link, d.tags)
  }
  
  val form = Form(
    mapping(
        "title" -> nonEmptyText,
        "department" -> optional(text),
        "link" -> text,
        "tags" -> text)
    	(Document.wrap)(Document.unwrap) 
      )
      
}