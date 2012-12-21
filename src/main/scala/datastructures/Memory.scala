package datastructures

/**
 * Created by kindone 11. 11. 26 오후 10:07
 */

class Memory(val size: Int, var sp: Int = 0) {
	private val array: Array[Double] = new Array(size)

	def push(value: Double): Double = {
		set(sp, value)
		sp += 1
		value
	}

	def pop(): Double = {
		sp -= 1
		val value = get(sp)
		value
	}

	def peek(): Double = {
		get(sp - 1)
	}

	def get(pos: Int) = array(scala.math.abs(pos) % size)

	def set(pos: Int, value: Double) = array(scala.math.abs(pos) % size) = value

	def length = size

}