package controllers

//import play.mvc.Controller
import play.api._
import play.api.mvc._

object SearchController extends Controller {

  def query(searchItem: String) = Action {
    //Ok("If you're looking for " + searchItem + " we suggest you search in your nearest shoebox first.")
    Ok(views.html.query("> "+searchItem))
  }
  
}