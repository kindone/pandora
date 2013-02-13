package population
import scala.math._
import datastructures.Memory

/**
 * Created by kindone 11. 11. 26 오후 9:57
 */

sealed trait Machine

object StackMachine {	
	val memSize = 10000
	
	val operators = Array[(StackMachine) => Double](_.add, _.subtract, _.multiply, _.divide, _.modular,
		_.or, _.and, _.not, _.xor, 
		_.shiftl, _.shiftr,
		_.toInt, _.toBoolean, 
		_.sqrt, _.pow, 
		_.eq, _.neq, _.geq, _.leq, _.gt, _.lt, _.isZero, _.isNonZero, 
		_.jumpRelative, _.jumpAbsolute, _.branchOnEq, _.branchOnNeq,
		_.load, _.store, _.sleep)
	
}

class StackMachine extends Machine with Individual {

	val memory: Memory = new Memory(StackMachine.memSize)

	// program counter
	var pc: Int = 0

	for (i <- 0 until StackMachine.memSize) memory.push(math.random)

	def work(): Double = {
		StackMachine.operators((scala.math.abs(memory.pop()) % StackMachine.operators.length).toInt)(this);
		val value = memory.peek()
		println(value)
		value
	}

	def peek(): Double = memory.peek()

	def push(value: Double) = memory.push(value)

	def pop(): Double = memory.pop()
	
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
	
	def pow(): Double = binaryOperation((x, y) => { scala.math.pow(x,y) })

	def not(): Double = unaryOperation((x) => { x.toInt ^ Int.MaxValue })

	def toInt(): Double = unaryOperation((x) => { x.toInt })

	def toBoolean(): Double = unaryOperation((x) => { if(x >= 0) 1 else 0 })

	def sqrt(): Double = unaryOperation((x) => { if(x > 0) math.sqrt(x) else if (x < 0 ) -math.sqrt(-x) else 0 })
	
	def eq(): Double = binaryOperation((x, y) => { if(x == y) 1 else 0 })
	
	def neq(): Double = binaryOperation((x, y) => { if(x != y) 1 else 0 })
	
	def geq(): Double = binaryOperation((x, y) => { if(x >= y) 1 else 0 })
	
	def leq(): Double = binaryOperation((x, y) => { if(x <= y) 1 else 0 })
	
	def gt(): Double = binaryOperation((x, y) => { if(x > y) 1 else 0 })
	
	def lt(): Double = binaryOperation((x, y) => { if(x < y) 1 else 0 })
	
	def isZero(): Double = unaryOperation((x) => { if(x == 0) 1 else 0 })
	
	def isNonZero(): Double = unaryOperation((x) => { if(x == 0) 1 else 0 })
	
	def jumpRelative(): Double = {
		val op = if(memory.length > 0) memory.pop else 0.0 
		
		memory.sp += op.toInt
		op // N/A
	} 
	
	def jumpAbsolute(): Double = {
		val op = if(memory.length > 0) memory.pop else 0.0 
			
		memory.sp = op.toInt
		op // N/A
	} 
	
	def branchOnEq(): Double = {
		if(eq() == 1)			
			jumpRelative()
		else
			0.0
	}
	
	def branchOnNeq(): Double = {
		if(neq() == 1)			
			jumpRelative()
		else
			0.0
	}
	
	def load(): Double = {
		val op = if(memory.length > 0) memory.pop else 0.0 
			
		memory.push(memory.get(op.toInt))
	}
	
	def store(): Double = {
		// address
		val op = if(memory.length > 0) memory.pop else 0.0 
		val op2 = if(memory.length > 0) memory.pop else 0.0 

		memory.set(op.toInt, op2)
		op2
	}
	
	def sleep(): Double = {
		Thread.sleep(100)
		0.0
	}
	
	

	private def unaryOperation(operator: (Double) => Double): Double = {
		val op = if(memory.length > 0) memory.pop else 0.0 

		val result = operator(op)
		memory.push(result)		
	}

	private def binaryOperation(operator: (Double, Double) => Double): Double = {
		val op1 = if(memory.length > 0) memory.pop else 0.0 
		val op2 = if(memory.length > 0) memory.pop else 0.0 

		val result = operator(op1, op2)		
		if(result.isNaN)  {			
			memory.push(0)			
		}
		else if(result.isPosInfinity)  {
			memory.push(1)			
		}
		else if(result.isNegInfinity)  {
			memory.push(-1)			
		}
		else {
			memory.push(result)			
		}
	}
}
