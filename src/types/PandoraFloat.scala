package types

/**
 * User: kindone
 * Date: 11. 8. 26. Time: 오후 10:29
 */

case class PandoraFloat(value:Float) extends PandoraValue{
  def +(other:PandoraValue):PandoraValue =  {
    other match {
      case PandoraByte(x) => PandoraFloat(value + x)
      case PandoraShort(x) => PandoraFloat(value + x)
      case PandoraInt(x) => PandoraFloat(value + x)
      case PandoraLong(x) => PandoraFloat(value + x)
      case PandoraFloat(x) => PandoraFloat(value + x)
      case PandoraDouble(x) => PandoraDouble(value + x)
    }
  }

  def -(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraFloat(value - x)
      case PandoraShort(x) => PandoraFloat(value - x)
      case PandoraInt(x) => PandoraFloat(value - x)
      case PandoraLong(x) => PandoraFloat(value - x)
      case PandoraFloat(x) => PandoraFloat(value - x)
      case PandoraDouble(x) => PandoraDouble(value - x)
    }
  }

  def *(other:PandoraValue):PandoraValue = {
    other match {
      case PandoraByte(x) => PandoraFloat(value * x)
      case PandoraShort(x) => PandoraFloat(value * x)
      case PandoraInt(x) => PandoraFloat(value * x)
      case PandoraLong(x) => PandoraFloat(value * x)
      case PandoraFloat(x) => PandoraFloat(value * x)
      case PandoraDouble(x) => PandoraDouble(value * x)
    }
  }

  def /(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraFloat(value / x)
      case PandoraShort(x) => PandoraFloat(value / x)
      case PandoraInt(x) => PandoraFloat(value / x)
      case PandoraLong(x) => PandoraFloat(value / x)
      case PandoraFloat(x) => PandoraFloat(value / x)
      case PandoraDouble(x) => PandoraDouble(value / x)
    }
  }

  def %(other:PandoraValue):PandoraValue = {
    other match {
      case PandoraByte(x) => PandoraFloat(value % x)
      case PandoraShort(x) => PandoraFloat(value % x)
      case PandoraInt(x) => PandoraFloat(value % x)
      case PandoraLong(x) => PandoraFloat(value % x)
      case PandoraFloat(x) => PandoraFloat(value % x)
      case PandoraDouble(x) => PandoraDouble(value % x)
    }
  }
}