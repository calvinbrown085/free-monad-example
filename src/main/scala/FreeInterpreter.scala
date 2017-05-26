package free.monad.example

import scalaz.concurrent.Task
import scalaz._, Scalaz._

object ChatInterpreter extends (Chat ~> Task) {

  def apply[A](chat: Chat[A]): Task[A] = chat match {
    case SendMessage(chat) => Task.delay{
      println(chat)
    }
    case GetMessage => Task.delay {
      scala.io.StdIn.readLine()
    }
  }
}
