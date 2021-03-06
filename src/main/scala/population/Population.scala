package population

trait Population {
	private val array: Array[Int] = Array()

	def apply(idx: Int) = {
		array(idx)
	}
}
