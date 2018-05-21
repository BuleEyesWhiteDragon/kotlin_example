abstract class SimilarityCalculator(val algorithmName: String){
	abstract fun calculate(string1: String, string2: String): Double

	fun name() = algorithmName	

	fun union(string1: String, string2: String): Set<Char> {
		return (string1 + string2)
		        .asSequence().toSet();
	}
	
	fun intersect(string1: String, string2: String): Set<Char> {
	    return string1.asSequence().toList()
				.intersect(string2.asIterable())
				.toSet()
	}
	
	fun countDouble(list: Collection<Char>): Double{
		val count = list.count()		
		println("list: ${list} ${count}")
	    return list.count().toDouble()	
	} 
}

class SimpsonIndex: SimilarityCalculator{
	constructor(): super("SimpsonIndex")	

	override fun calculate(string1: String, string2: String): Double {
	    return countDouble(intersect(string1, string2)) / Math.min(string1.length, string2.length).toDouble();
	}
}

class JaccardIndex: SimilarityCalculator{
	constructor(): super("JaccardIndex")
	override fun calculate(string1: String, string2: String): Double{
		return countDouble(intersect(string1, string2)) / countDouble(union(string1, string2))
				
	}
}

class DiceIndex: SimilarityCalculator{
	constructor(): super("DiceIndex")

	override fun calculate(string1: String, string2: String): Double {
		return (2.0 * countDouble(intersect(string1, string2))) /
				(string1.length + string2.length).toDouble()
	}	
}

class CosineSimilarity: SimilarityCalculator{
	constructor(): super("Cosine")

	override fun calculate(string1: String, string2: String): Double {
	    val union = union(string1, string2);
	    val vector1 = vectorize(union, string1);
		val vector2 = vectorize(union, string2);

		return innerproduct(vector1, vector2) / (length(vector1) * length(vector2))
	}
	
	fun innerproduct(vector1: Map<Char, Int>, vector2: Map<Char, Int>): Double{
		return vector1.values.zip(vector2.values)
		        .map { (v1, v2) -> v1 * v2 }
		        .sum().toDouble()
	}

	fun length(vector: Map<Char, Int>): Double{
		return Math.sqrt(vector.values.map{ it -> it * it }
				.sum().toDouble())
	}

	fun vectorize(union: Set<Char>, string: String): Map<Char, Int> {
		return union.map { c -> Pair(c, countCharsInTheString(string, c)) }
		        .toMap()
	}
	fun countCharsInTheString(string: String, c: Char): Int{
		return string.asSequence()
				.filter { item -> item == c }
		        .count();
	}
}

class Similarities{
    fun calculators(): List<SimilarityCalculator>{
        return listOf(SimpsonIndex(), JaccardIndex(), DiceIndex(), CosineSimilarity())
    }
}