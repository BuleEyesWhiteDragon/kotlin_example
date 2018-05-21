fun run(args: Array<String>){
	if(hasNoError(args))
		printSimilarities(args[0], args[1])
}

fun printSimilarities(string1: String, string2: String){
	Similarities().calculators()
	.map { algorithm -> Pair(algorithm.name(), algorithm.calculate(string1, string2)) }
	.forEach{ pair -> println("${pair.first}(${string1}, ${string2}) = ${pair.second}") }
}

fun hasNoError(args: Array<String>): Boolean = args.size == 2

fun main(args: Array<String>){
	run(args)
}