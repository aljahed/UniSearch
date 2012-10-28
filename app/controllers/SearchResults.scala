package controllers

import play.api._
import play.api.mvc._
import models._
import java.net.URL

object SearchResults extends Controller {
  
  def index = Action {
    val results = mockResults
    Ok(views.html.results("Results found " + results.size, results))
  }
  
  private def mockResults(): List[SearchResult] = {
    List(ScriptResult(new URL("http://www.tcs.ifi.lmu.de/lehre/ws-2010-11/kompl/manuskript-1"), 1),
        TutorialResult(new URL("http://www.tcs.ifi.lmu.de/lehre/ws-2010-11/kompl/blatt-01"),2),
        TutorialResult(new URL("http://www.tcs.ifi.lmu.de/lehre/ws-2010-11/kompl/blatt-02"),1),
        ScriptResult(new URL("http://www.tcs.ifi.lmu.de/lehre/ws-2010-11/kompl/manuskript-2"),2),
        OtherResult(new URL("http://www.thi.uni-hannover.de/fileadmin/forschung/publikationen/daten/vollmer99b.ps.gz"),1))
        .sortWith((r1,r2) => r1.ranking < r2.ranking)
  }
}