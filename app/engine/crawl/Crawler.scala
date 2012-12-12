package engine.crawl

import models.Document
import scala.io.Source
import scala.xml._

/**
 * Basic trait for crawler implementations.
 */
trait Crawler {

  val LINK_DEPTH: Int

  def findDocuments(url: String): List[Document]

  /**
   * Loads and html page into an xml document.
   */
  def loadHTML(url: String): Elem = {
    XML.withSAXParser(new org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl().newSAXParser())
    XML.load(new org.xml.sax.InputSource(url))
  }

}