package io.github.binout.kotlin.jenkins

interface Executable {

    fun execute()
}

class Echo(private val msg: String) : Executable {

    override fun execute() = println(msg)
}

class Stage(val name: String, private val steps: List<Executable>) : Executable {

    override fun execute() {
        println("Execute $name")
        steps.forEach { it.execute() }
    }

}

class JenkinsPipeline(private val agent: String, private val stages: List<Stage>) : Executable {

    override fun execute() {
        println("Running on $agent")
        stages.forEach { it.execute() }
    }

}