package population
import scala.math._
import datastructures.{ FixedSizeMemory => Memory }

/**
 * Created by kindone 11. 11. 26 오후 9:57
 */

sealed trait Machine

object StackMachine {
	val memSize = 65536

	val operators = Array[(StackMachine) => () => Double](_.add, _.subtract, _.multiply, _.divide, _.modular,
		_.or, _.and, _.not, _.xor,
		_.shiftl, _.shiftr,
		_.toInt, _.toBoolean,
		_.sqrt, _.pow,
		_.eq, _.neq, _.geq, _.leq, _.gt, _.lt, _.isZero, _.isNonZero,
		_.jumpRelative, _.jumpAbsolute, _.branchOnEq, _.branchOnNeq,
		_.load, _.store, _.sleep)

}

trait StackMachine extends Machine { self: WorkerActor =>
	import StackMachine._

	val memory: Memory = new Memory(StackMachine.memSize)
	// stack pointer
	var sp = 0
	// program counter
	var pc = 0

	def push(value: Double): Double = {
		memory.set(sp, value)
		sp += 1
		value
	}

	def pop(): Double = {
		sp -= 1
		val value = memory.get(sp)
		value
	}

	def peek(): Double = {
		memory.get(sp - 1)
	}

	def work(): Boolean = {
		val operation = StackMachine.operators((scala.math.abs(if (pc == Int.MinValue) pc + 1 else pc) % StackMachine.operators.length).toInt)
		val result = operation(this)();
		pc += 1
		operation(this) != sleep _
	}

	def add(): Double = binaryOperation((x, y) => x + y)

	def subtract(): Double = binaryOperation((x, y) => x - y)

	def multiply(): Double = binaryOperation((x, y) => x * y)

	def divide(): Double = binaryOperation((x, y) => { if (scala.math.abs(y) <= 0.1E-6) 0 else x / y })

	def modular(): Double = binaryOperation((x, y) => x % y)

	def and(): Double = binaryOperation((x, y) => { x.toInt & y.toInt })

	def or(): Double = binaryOperation((x, y) => x.toInt | y.toInt)

	def xor(): Double = binaryOperation((x, y) => x.toInt ^ y.toInt)

	def shiftl(): Double = binaryOperation((x, y) => x.toInt << y.toInt)

	def shiftr(): Double = binaryOperation((x, y) => x.toInt >> y.toInt)

	def pow(): Double = binaryOperation((x, y) => { scala.math.pow(x, y) })

	def not(): Double = unaryOperation((x) => { x.toInt ^ Int.MaxValue })

	def toInt(): Double = unaryOperation((x) => { x.toInt })

	def toBoolean(): Double = unaryOperation((x) => { if (x >= 0) 1 else 0 })

	def sqrt(): Double = unaryOperation((x) => { if (x > 0) math.sqrt(x) else if (x < 0) -math.sqrt(-x) else 0 })

	def eq(): Double = binaryOperation((x, y) => { if (x == y) 1 else 0 })

	def neq(): Double = binaryOperation((x, y) => { if (x != y) 1 else 0 })

	def geq(): Double = binaryOperation((x, y) => { if (x >= y) 1 else 0 })

	def leq(): Double = binaryOperation((x, y) => { if (x <= y) 1 else 0 })

	def gt(): Double = binaryOperation((x, y) => { if (x > y) 1 else 0 })

	def lt(): Double = binaryOperation((x, y) => { if (x < y) 1 else 0 })

	def isZero(): Double = unaryOperation((x) => { if (x == 0) 1 else 0 })

	def isNonZero(): Double = unaryOperation((x) => { if (x == 0) 1 else 0 })

	def jumpRelative(): Double = {
		val op = pop

		pc += op.toInt
		op // N/A
	}

	def jumpAbsolute(): Double = {
		val op = if (memory.length > 0) pop else 0.0

		pc = op.toInt
		op // N/A
	}

	def branchOnEq(): Double = {
		if (eq() == 1)
			jumpRelative()
		else
			0.0
	}

	def branchOnNeq(): Double = {
		if (neq() == 1)
			jumpRelative()
		else
			0.0
	}

	def load(): Double = {
		val op = pop
		push(memory.get(op.toInt))
	}

	def store(): Double = {
		// address
		val op = pop
		val op2 = pop

		memory.set(op.toInt, op2)
		op2
	}

	def sleep(): Double = {
		0.0
	}

	private def unaryOperation(operator: (Double) => Double): Double = {
		val op = pop

		val result = operator(op)
		push(result)
	}

	private def binaryOperation(operator: (Double, Double) => Double): Double = {
		val op1 = pop
		val op2 = pop

		val result = operator(op1, op2)
		if (result.isNaN) {
			push(0)
		} else if (result.isPosInfinity) {
			push(1)
		} else if (result.isNegInfinity) {
			push(-1)
		} else {
			push(result)
		}
	}
}
