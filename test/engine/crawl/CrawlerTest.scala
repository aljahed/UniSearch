package engine.crawl

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.concurrent.Timeouts
import org.scalatest.time.SpanSugar._
import scala.io.Source
import scala.xml._

class CrawlerTest extends FunSuite with ShouldMatchers with Timeouts {

  private val testURL = "http://www.mukis.de"
  private val testURL2 = "http://mukis.de/pages/?p=290"

  test("Load from URL") {
    val in = Source.fromURL(testURL)
  }

  test("Load XML from URL") {
    val xml = XML.load(testURL)
    val meta = xml \\ "title"
    println("Title " + meta.text)
  }

  test("Load <a> tags from URL") {
    // fails on crappy html/xml code
    XML.withSAXParser(new org.ccil.cowan.tagsoup.jaxp.SAXFactoryImpl().newSAXParser())
    val source = new org.xml.sax.InputSource(testURL2)
    //XML.loadXML(source, new HTML5Parser)
    var html:Elem = null
    failAfter (200 seconds) {
      html = XML.load(testURL2) 
    }
    html should not be(null)
    
    println(html \\ "title")
  }

}