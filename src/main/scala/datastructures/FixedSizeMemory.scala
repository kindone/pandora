package datastructures

/**
 * Created by kindone 11. 11. 26 오후 10:07
 */

class FixedSizeMemory(val size: Int) {
	private val array: Array[Double] = new Array(size)

	def get(pos: Int) = { array(scala.math.abs(if (pos == Int.MinValue) pos + 1 else pos) % size) }

	def set(pos: Int, value: Double) = array(scala.math.abs(if (pos == Int.MinValue) pos + 1 else pos) % size) = value

	def length = size

	def <<(values: List[Double]) = {
	}

}
