package com.jackchapman.adventofcode

val days: Map<Int, () -> Pair<Any, Any>> = mapOf(
    1 to { solveDay1() },
    2 to { solveDay2() },
    3 to { solveDay3() },
    4 to { solveDay4() },
    5 to { solveDay5() },
    6 to { solveDay6() },
    7 to { solveDay7() },
    8 to { solveDay8() },
)

fun main(args: Array<String>) {
    if (args.isNotEmpty()) {
        if (days.containsKey(args[0].toIntOrNull()))
            println(format(args[0].toInt()))
        else
            println("!! Not a valid day !!")
    } else {
        days.keys.forEach { println(format(it)) }
    }
}

fun format(challenge: Int?): String {
    val p = days[challenge]!!.invoke()
    return """
            <<------------------| Day $challenge |------------------>>
                  https://adventofcode.com/2020/day/$challenge 
                       
            Part 1: ${p.first}
            Part 2: ${p.second}
            
    """.trimIndent()
}

fun getInput(day: Int): List<String> {
    return {}::class.java.classLoader.getResourceAsStream("Day${day.toString().padStart(2, '0')}.txt")?.bufferedReader()
        ?.readLines()!!
}
