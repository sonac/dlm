import sbt._

object Dependencies {

  lazy val catsEffectV = "1.3.0"
  lazy val scoptV = "4.0.0-RC2"

  lazy val castEffect = "org.typelevel" %% "cats-effect" % catsEffectV
  lazy val scopt = "com.github.scopt" %% "scopt" % scoptV

  lazy val dependencies: Seq[ModuleID] = Seq(
    castEffect,
    scopt
  )
}
