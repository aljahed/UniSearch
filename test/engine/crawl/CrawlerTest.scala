package engine.crawl

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers
import scala.io.Source
import scala.xml._

class CrawlerTest extends FunSuite with ShouldMatchers {
  
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
    //val xml = XML.load(testURL2)
  }
  
}