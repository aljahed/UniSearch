package controllers

import play.api._
import play.api.mvc._
import models._

object Admin extends Controller {

  def index = Action  {
    Ok(views.html.admin(Document.form))
  }
  
  def submit = Action {
    Ok(views.html.admin(Document.form))
  }
  
}