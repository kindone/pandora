package object datastructures {
	type Operand = Any {
		def +(other:Int):AnyVal
		def +(other:Long):AnyVal
		def +(other:Char):AnyVal
	}
	
	type ¬[A] = A => Nothing
	type ∨[T, U] = ¬[¬[T] with ¬[U]]
	type ¬¬[A] = ¬[¬[A]]
	type |∨|[T, U] = { type λ[X] = ¬¬[X] <:< (T ∨ U) }
	
	type Primitives = Int |∨| Long |∨| Char |∨| Double |∨| Float
	
}
