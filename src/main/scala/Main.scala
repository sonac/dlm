import sys.process._
import java.io.File
import java.net.URL

import ArgConfig.parser
import cats.effect._
import cats.syntax.all._
import scopt.OParser

object Main extends IOApp {

  def run(args: List[String]): IO[ExitCode] = {
    if (args.nonEmpty) {
      OParser.parse(parser, args, ArgConfig()) match {
        case Some(args) => IO {
          val path = args.downloadLocation.getOrElse("")
          val fileName = args.filename.getOrElse(args.url.split("/").last)
          new URL(args.url) #> new File(path + fileName) !!
        }.as(ExitCode.Success)
        case None => IO(System.err.println("Wrong arguments")).as(ExitCode(2))
      }
    }
    else IO(System.err.println("Provide arguments")).as(ExitCode(2))
  }
}
