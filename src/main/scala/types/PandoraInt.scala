package types

case class PandoraInt(value: Int) extends PandoraValue {

	def +(other: PandoraValue): PandoraValue = {
		other match {
			case PandoraByte(x) => PandoraInt(value + x)
			case PandoraShort(x) => PandoraInt(value + x)
			case PandoraInt(x) => PandoraInt(value + x)
			case PandoraLong(x) => PandoraLong(value + x)
			case PandoraFloat(x) => PandoraFloat(value + x)
			case PandoraDouble(x) => PandoraDouble(value + x)
		}
	}

	def -(other: PandoraValue): PandoraValue = {
		other match {
			case PandoraByte(x) => PandoraInt(value - x)
			case PandoraShort(x) => PandoraInt(value - x)
			case PandoraInt(x) => PandoraInt(value - x)
			case PandoraLong(x) => PandoraLong(value - x)
			case PandoraFloat(x) => PandoraFloat(value - x)
			case PandoraDouble(x) => PandoraDouble(value - x)
		}
	}

	def *(other: PandoraValue): PandoraValue = {
		other match {
			case PandoraByte(x) => PandoraInt(value * x)
			case PandoraShort(x) => PandoraInt(value * x)
			case PandoraInt(x) => PandoraInt(value * x)
			case PandoraLong(x) => PandoraLong(value * x)
			case PandoraFloat(x) => PandoraFloat(value * x)
			case PandoraDouble(x) => PandoraDouble(value * x)
		}
	}

	def /(other: PandoraValue): PandoraValue = {
		other match {
			case PandoraByte(x) => PandoraInt(value / x)
			case PandoraShort(x) => PandoraInt(value / x)
			case PandoraInt(x) => PandoraInt(value / x)
			case PandoraLong(x) => PandoraLong(value / x)
			case PandoraFloat(x) => PandoraFloat(value / x)
			case PandoraDouble(x) => PandoraDouble(value / x)
		}
	}

	def %(other: PandoraValue): PandoraValue = {
		other match {
			case PandoraByte(x) => PandoraInt(value % x)
			case PandoraShort(x) => PandoraInt(value % x)
			case PandoraInt(x) => PandoraInt(value % x)
			case PandoraLong(x) => PandoraLong(value % x)
			case PandoraFloat(x) => PandoraFloat(value % x)
			case PandoraDouble(x) => PandoraDouble(value % x)
		}
	}
}