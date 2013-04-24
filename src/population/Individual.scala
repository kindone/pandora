package population
import akka.actor.Actor
import akka.actor.actorRef2Scala
import messages._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

trait WorkerActor extends Actor {

	def work(): Boolean

	def receive = {
		case Work =>
      work()
      
			if(work())
    			sender ! WorkDone
            else  {
                val savedSender = sender
                context.system.scheduler.scheduleOnce(1 second, savedSender, WorkDone) 
            }

		case WorkDone =>
      // unused
        case _ =>
			println("some undefined message")
			sender ! -1
	}
}

class RandomIndividual extends WorkerActor with StackMachine {
}

class Replicator extends WorkerActor with StackMachine {

}
