package simulation

import population.StackMachine
import akka.actor._
import messages._
import population._
import akka.routing.RoundRobinRouter

/**
 * Created by IntelliJ IDEA.
 * User: kindone
 * Date: 11. 11. 28
 * Time: 오후 10:09
 * To change this template use File | Settings | File Templates.
 */

object DefaultSimulation {
	val numIndividuals = 1
}

class DefaultSimulation extends Actor {

	//	val population = Array.fill(DefaultSimulation.numIndividuals)(new StackMachine)

	val individualRouter = context.actorOf(
		Props[WorkerActor].withRouter(RoundRobinRouter(nrOfInstances=DefaultSimulation.numIndividuals)),
		name = "workerRouter")

	var i = 0

	def receive = {
		case Commence =>
			for(i <- 0 to (DefaultSimulation.numIndividuals-1))
				individualRouter ! Work
		case WorkDone =>
			individualRouter ! Work
	}

}
