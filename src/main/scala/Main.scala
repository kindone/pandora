
import population.StackMachine
import simulation.DefaultSimulation
import messages._
import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props
import population.StackMachine

/**
 * Created by kindone 11. 11. 26 오후 9:46
 */

object Main {

	def main(args: Array[String]) {
		// start DefaultSimulator act()
		val system = ActorSystem("pandora")
		val simulation = system.actorOf(Props(new DefaultSimulation()), name = "simulation")

		simulation ! Commence

	}
}
