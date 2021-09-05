import java.util.*
import kotlin.collections.HashSet


fun main() {
    val graph = makeGraph()
    graph.bfs(0)
}

private fun makeGraph(): Graph {
    println("Enter number of vertices and edges")
    val scanner = Scanner(System.`in`)
    val v: Int = scanner.nextInt()
    val e: Int = scanner.nextInt()

    val graph = Graph(v)
    println("Enter edges")
    for (i in 0 until e) {
        val source: Int = scanner.nextInt()
        val destination: Int = scanner.nextInt()
        graph.addEdge(source, destination)
    }
    scanner.close()
    return graph
}

class Graph(v: Int) {

    private val adj: Array<LinkedList<Int>?> = Array(v) { null }

    init {
        for (i in 0 until v) {
            adj[i] = LinkedList()
        }
    }

    fun addEdge(source: Int, destination: Int) {
        adj[source]?.add(destination)
        adj[destination]?.add(source)
    }

    fun bfs(source: Int) {
        val queue: Queue<Int> = LinkedList()
        val seen = HashSet<Int>()

        queue.add(source)

        while (!queue.isEmpty()) {
            val curr = queue.poll()

            if (!seen.contains(curr)) {
                seen.add(curr)
                println(curr)
            }

            for (adjacent in adj[curr]!!) {
                if (!seen.contains(adjacent)) {
                    queue.add(adjacent)
                }
            }
        }


    }

    fun dfs(start: Int) {
        val stack = Stack<Int>()
        val seen = HashSet<Int>()

        stack.push(start)

        while (!stack.isEmpty()) {
            val curr = stack.pop()

            if (!seen.contains(curr)) {
                seen.add(curr)
                println(curr)
            }
            for (adjacent in adj[curr]!!) {
                if (!seen.contains(adjacent)) {
                    stack.push(adjacent)
                }
            }
        }
    }

    fun dfsRecursive(start: Int, destination: Int):Boolean {
        val seen = HashSet<Int>()
        seen.add(start)
        return dfsUtil(start, destination, seen)
    }

    private fun dfsUtil(source: Int, destination: Int, seen: HashSet<Int>): Boolean {
        if (source == destination) return true
        for (neighbor in adj[source]!!) {
            if (!seen.contains(neighbor)) {
                seen.add(neighbor)
                val isConnected = dfsUtil(neighbor, destination, seen)
                if (isConnected) return true
            }
        }
        return false
    }


}
