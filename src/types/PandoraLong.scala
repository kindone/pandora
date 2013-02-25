package types

/**
 * User: kindone
 * Date: 11. 8. 26. Time: 오후 10:29
 */

case class PandoraLong(value:Long) extends PandoraValue{
  def +(other:PandoraValue):PandoraValue =  {
    other match {
      case PandoraByte(x) => PandoraLong(value + x)
      case PandoraShort(x) => PandoraLong(value + x)
      case PandoraInt(x) => PandoraLong(value + x)
      case PandoraLong(x) => PandoraLong(value + x)
      case PandoraFloat(x) => PandoraFloat(value + x)
      case PandoraDouble(x) => PandoraDouble(value + x)
    }
  }

  def -(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraLong(value - x)
      case PandoraShort(x) => PandoraLong(value - x)
      case PandoraInt(x) => PandoraLong(value - x)
      case PandoraLong(x) => PandoraLong(value - x)
      case PandoraFloat(x) => PandoraFloat(value - x)
      case PandoraDouble(x) => PandoraDouble(value - x)
    }
  }

  def *(other:PandoraValue):PandoraValue = {
    other match {
      case PandoraByte(x) => PandoraLong(value * x)
      case PandoraShort(x) => PandoraLong(value * x)
      case PandoraInt(x) => PandoraLong(value * x)
      case PandoraLong(x) => PandoraLong(value * x)
      case PandoraFloat(x) => PandoraFloat(value * x)
      case PandoraDouble(x) => PandoraDouble(value * x)
    }
  }

  def /(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraLong(value / x)
      case PandoraShort(x) => PandoraLong(value / x)
      case PandoraInt(x) => PandoraLong(value / x)
      case PandoraLong(x) => PandoraLong(value / x)
      case PandoraFloat(x) => PandoraFloat(value / x)
      case PandoraDouble(x) => PandoraDouble(value / x)
    }
  }

  def %(other:PandoraValue):PandoraValue = {
    other match {
      case PandoraByte(x) => PandoraLong(value % x)
      case PandoraShort(x) => PandoraLong(value % x)
      case PandoraInt(x) => PandoraLong(value % x)
      case PandoraLong(x) => PandoraLong(value % x)
      case PandoraFloat(x) => PandoraFloat(value % x)
      case PandoraDouble(x) => PandoraDouble(value % x)
    }
  }
}