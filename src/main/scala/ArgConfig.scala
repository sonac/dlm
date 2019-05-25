import scopt.{OParser, OParserBuilder}

case class ArgConfig(
 url: String = "",
 downloadLocation: Option[String] = None,
 filename: Option[String] = None
)

object ArgConfig {

  val builder: OParserBuilder[ArgConfig] = OParser.builder[ArgConfig]
  val parser = {
    import builder._
    OParser.sequence(
      programName("scopt"),

      head("scopt", "4.0"),

      opt[String]('u', "url")
          .action((x, c) => c.copy(url = x))
          .text("url to download"),

      opt[String]('d', "downloadLocation")
          .action((x, c) => c.copy(downloadLocation = Some(x)))
          .text("download location"),

      opt[String]('f', "filename")
        .action((x, c) => c.copy(filename = Some(x)))
        .text("filename"),

      help("help").text("Usage : sbt run " +
        "--url <url to download>" +
        "--downloadLocation <where to download>" +
        "--filename <to which file download>"
      )
    )
  }

}