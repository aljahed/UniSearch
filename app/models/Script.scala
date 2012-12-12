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
import mongoContext._

case class Script(id: ObjectId = new ObjectId,
  title: String,
  department: Option[String],
  link: String,
  release: Date,
  tags: String = "",
  tutorials: List[ObjectId] = Nil) extends IDocument

object Script extends ModelCompanion[Script, ObjectId] {
  // Play salat
  val dao = new SalatDAO[Script, ObjectId](collection = mongoCollection("UniSearch")) {}

  // Play form
  def wrap(title: String, department: Option[String], link: String, release: Date, tags: String): Script = {
    Script(new ObjectId, title, department, link, release, tags)
  }

  def unwrap(d: Script) = {
    Some(d.title, d.department, d.link, d.release, d.tags)
  }

  val form = Form(
    mapping(
      "title" -> nonEmptyText,
      "department" -> optional(text),
      "link" -> text,
      "release" -> date,
      "tags" -> text)(Script.wrap)(Script.unwrap))

}