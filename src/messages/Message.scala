package messages

sealed trait IndividualMessage
case object Work extends IndividualMessage
case object WorkDone extends IndividualMessage


sealed trait SimulationMessage
case object Commence extends SimulationMessage