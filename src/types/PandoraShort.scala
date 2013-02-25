package types

/**
 * Created by IntelliJ IDEA.
 * User: kindone
 * Date: 11. 8. 25.
 * Time: 오후 10:10
 * To change this template use File | Settings | File Templates.
 */

case class PandoraShort(value:Short) extends PandoraValue{
  def +(other:PandoraValue):PandoraValue =  {
    other match {
      case PandoraByte(x) => PandoraInt(value + x)
      case PandoraShort(x) => PandoraInt(value + x)
      case PandoraInt(x) => PandoraInt(value + x)
      case PandoraLong(x) => PandoraLong(value + x)
      case PandoraFloat(x) => PandoraFloat(value + x)
      case PandoraDouble(x) => PandoraDouble(value + x)
    }
  }

  def -(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraInt(value - x)
      case PandoraShort(x) => PandoraInt(value - x)
      case PandoraInt(x) => PandoraInt(value - x)
      case PandoraLong(x) => PandoraLong(value - x)
      case PandoraFloat(x) => PandoraFloat(value - x)
      case PandoraDouble(x) => PandoraDouble(value - x)
    }
  }

  def *(other:PandoraValue):PandoraValue = {
    other match {
      case PandoraByte(x) => PandoraInt(value * x)
      case PandoraShort(x) => PandoraInt(value * x)
      case PandoraInt(x) => PandoraInt(value * x)
      case PandoraLong(x) => PandoraLong(value * x)
      case PandoraFloat(x) => PandoraFloat(value * x)
      case PandoraDouble(x) => PandoraDouble(value * x)
    }
  }

  def /(other:PandoraValue):PandoraValue = {
     other match {
      case PandoraByte(x) => PandoraInt(value / x)
      case PandoraShort(x) => PandoraInt(value / x)
      case PandoraInt(x) => PandoraInt(value / x)
      case PandoraLong(x) => PandoraLong(value / x)
      case PandoraFloat(x) => PandoraFloat(value / x)
      case PandoraDouble(x) => PandoraDouble(value / x)
    }
  }

  def %(other:PandoraValue):PandoraValue = {
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