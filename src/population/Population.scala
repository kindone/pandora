package population


trait Population {
	private val array = Array()
	
	def apply(idx:Int) = {
		array(idx)
	}
}