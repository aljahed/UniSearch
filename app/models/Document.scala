package models
import java.util.Date

trait IDocument {

  val title: String
  val department: Option[String]
  val link: String
  val release: Date
  val tags: String
  
}