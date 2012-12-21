package population
import akka.actor.Actor
import akka.actor.actorRef2Scala
import messages._

trait Individual extends Actor {
	def work(): Double

	def receive = {
		case Work =>
			work()
			sender ! WorkDone

		case _ =>
			println("some undefined message")
			sender ! -1
	}
}