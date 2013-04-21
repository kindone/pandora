package population
import akka.actor.Actor
import akka.actor.actorRef2Scala
import messages._

trait WorkerActor extends Actor {
	def work(): Double

	def receive = {
		case Work =>
			work()
			sender ! WorkDone

		case WorkDone =>
      // unused
    case _ =>
			println("some undefined message")
			sender ! -1
	}
}


