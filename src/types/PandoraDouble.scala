package types

/**
 * User: kindone
 * Date: 11. 8. 26. Time: 오후 10:14
 */

case class PandoraDouble(value:Double) extends PandoraValue{
  def +(other:PandoraValue):PandoraValue =  {
    other match {
      case PandoraByte(x) => PandoraDouble(value + x)
      case PandoraShort(x) => PandoraDouble(value + x)
      case PandoraInt(x) => PandoraDouble(value + x)
      case PandoraLong(x) => PandoraDouble(value + x)
      case PandoraFloat(x) => PandoraDouble(value + x)
      case PandoraDouble(x) => PandoraDouble(value + x)
    }
  }

  def -(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraDouble(value - x)
      case PandoraShort(x) => PandoraDouble(value - x)
      case PandoraInt(x) => PandoraDouble(value - x)
      case PandoraLong(x) => PandoraDouble(value - x)
      case PandoraFloat(x) => PandoraDouble(value - x)
      case PandoraDouble(x) => PandoraDouble(value - x)
    }
  }

  def *(other:PandoraValue):PandoraValue = {
    other match {
      case PandoraByte(x) => PandoraDouble(value * x)
      case PandoraShort(x) => PandoraDouble(value * x)
      case PandoraInt(x) => PandoraDouble(value * x)
      case PandoraLong(x) => PandoraDouble(value * x)
      case PandoraFloat(x) => PandoraDouble(value * x)
      case PandoraDouble(x) => PandoraDouble(value * x)
    }
  }

  def /(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraDouble(value / x)
      case PandoraShort(x) => PandoraDouble(value / x)
      case PandoraInt(x) => PandoraDouble(value / x)
      case PandoraLong(x) => PandoraDouble(value / x)
      case PandoraFloat(x) => PandoraDouble(value / x)
      case PandoraDouble(x) => PandoraDouble(value / x)
    }
  }

  def %(other:PandoraValue):PandoraValue = {
    other match {
      case PandoraByte(x) => PandoraDouble(value % x)
      case PandoraShort(x) => PandoraDouble(value % x)
      case PandoraInt(x) => PandoraDouble(value % x)
      case PandoraLong(x) => PandoraDouble(value % x)
      case PandoraFloat(x) => PandoraDouble(value % x)
      case PandoraDouble(x) => PandoraDouble(value % x)
    }
  }
}