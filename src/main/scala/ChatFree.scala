package free.monad.example

import scalaz._, Scalaz._
import scalaz.concurrent.Task

sealed trait Chat[A]
case class SendMessage(message: String) extends Chat[Unit]
case object GetMessage extends Chat[String]


object Chat {
  def sendMessage(message: String): Free[Chat, Unit] = Free.liftF(SendMessage(message))
  def getMessage(): Free[Chat, String] = Free.liftF(GetMessage)

}


object RunChat extends App {

  import Chat._

  val program: Free[Chat, Unit] = for {
    _ <- sendMessage("Hello")
    name <- getMessage()
    _ <- sendMessage(s"Hello $name")
  } yield ()

  val task: Task[Unit] = program.foldMap(ChatInterpreter)
  task.unsafePerformSync
}
