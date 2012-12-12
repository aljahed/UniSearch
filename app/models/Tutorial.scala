package models

import play.api.Play.current
import java.util.Date
import com.novus.salat._
import com.novus.salat.annotations._
import com.novus.salat.dao._
import com.mongodb.casbah.Imports._
import se.radley.plugin.salat._
import mongoContext._

case class Tutorial(id: ObjectId = new ObjectId,
  title: String,
  department: Option[String],
  link: String,
  release: Date,
  tags: String = "") extends IDocument

object Tutorial extends ModelCompanion[Tutorial, ObjectId] {
  val dao = new SalatDAO[Tutorial, ObjectId](collection = mongoCollection("UniSearch")) {}
}