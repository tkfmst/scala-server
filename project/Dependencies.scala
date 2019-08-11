import sbt._

object Versions {
  val Scala = "2.13.0"

  val cats       = "2.0.0-M4"
  val catsEffect = "2.0.0-RC1"
  val http4s     = "0.21.0-M3"
  val simulacrum = "0.19.0"
}

object Dependencies {
  lazy val serverDependencies = Seq(
    Libraries.catsCore,
    Libraries.catsEffect,
    Libraries.http4sDSL,
    Libraries.http4sBlazeClient,
    Libraries.http4sBlazeServer,
    Libraries.simulacrum,
  )
}

object Libraries {
  // cats
  private[this] def cats(artId: String) = "org.typelevel" %% artId % Versions.cats
  lazy val catsCore = cats("cats-core" )

  // cats-effect
  lazy val catsEffect = "org.typelevel" %% "cats-effect" % Versions.catsEffect

  // http4s
  private[this] def http4s(artId: String) =  "org.http4s" %% artId % Versions.http4s
  lazy val http4sDSL         = http4s("http4s-dsl")
  lazy val http4sBlazeClient = http4s("http4s-blaze-client")
  lazy val http4sBlazeServer = http4s("http4s-blaze-server")

  // simulacrum
  lazy val simulacrum = "com.github.mpilquist" %% "simulacrum" % Versions.simulacrum
}
