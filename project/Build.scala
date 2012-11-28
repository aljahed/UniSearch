import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

  val appName = "UniSearch"
  val appVersion = "1.0-SNAPSHOT"

 
  val appDependencies = Seq(
    "se.radley" %% "play-plugins-salat" % "1.1",
    "org.scalatest" %% "scalatest" % "1.8" % "test")

  // Only compile the bootstrap bootstrap.less file and any other *.less file in the stylesheets directory
  def customLessEntryPoints(base: File): PathFinder = (
      (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
      (base / "app" / "assets" / "stylesheets" * "*.less")
  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    // Add your own project settings here    
    templatesImport += "models._",
    routesImport += "se.radley.plugin.salat.Binders._",
    templatesImport += "org.bson.types.ObjectId",
    lessEntryPoints <<= baseDirectory(customLessEntryPoints),
    testOptions in Test := Nil)

}
