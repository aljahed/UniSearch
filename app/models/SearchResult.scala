package models
import java.net.URL

/**
 * Base trait for search results. Will need some more love
 * and methods.
 *
 * @author muki
 * @version 0.1
 */
trait SearchResult {

  /**
   * @return the url to the underlying document
   */
  def url: URL
  
  /**
   * @return ranking within the results
   */
  def ranking: Int

  /**
   * Default implementation returns last element of URL without
   * file extension.
   *
   * @return name of the result
   */
  def name: String = url.getPath.substring(url.getPath.lastIndexOf("/")+1).replaceAll("\\.\\w{0,3}$", "")

  /**
   * //TODO maybe better to implement this in each subclass
   * 
   * @return the name of this type which maps to a css class
   */
  def resultType: String = this match {
    case ScriptResult(_,_) => "script"
    case TutorialResult(_,_) => "tutorial"
    case OtherResult(_,_) => "other"
  }
}

case class ScriptResult(val url: URL, val ranking: Int) extends SearchResult
case class TutorialResult(val url: URL, val ranking: Int) extends SearchResult
case class OtherResult(val url: URL, val ranking: Int) extends SearchResult