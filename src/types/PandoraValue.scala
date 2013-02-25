package types

/**
 * Created by IntelliJ IDEA.
 * User: kindone
 * Date: 11. 8. 25.
 * Time: 오후 10:11
 * To change this template use File | Settings | File Templates.
 */

abstract class PandoraValue {

  def +(other:PandoraValue):PandoraValue;
  def -(other:PandoraValue):PandoraValue;
  def *(other:PandoraValue):PandoraValue;
  def /(other:PandoraValue):PandoraValue;
  def %(other:PandoraValue):PandoraValue;

}