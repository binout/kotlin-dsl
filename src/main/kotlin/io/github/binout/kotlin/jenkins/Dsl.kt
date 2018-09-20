package io.github.binout.kotlin.jenkins

object pipeline {

    operator fun invoke(init: PipelineContext.() -> Unit) : JenkinsPipeline {
        val pipelineContext = PipelineContext()
        pipelineContext.init()
        return pipelineContext.build()
    }

}

class PipelineContext(var agent: String = "") {

    lateinit var stageContext: StageContext

    fun stages(init: StageContext.() -> Unit) {
        stageContext = StageContext()
        stageContext.apply(init)
    }

    fun build(): JenkinsPipeline {
        return JenkinsPipeline(agent, stages = listOf(
                Stage(stageContext.stageName, listOf(
                        Echo(stageContext.stepContext.taskContext.echo)))))
    }

}

class StageContext {

    lateinit var stepContext: StepContext
    lateinit var stageName: String

    fun stage(name: String, init: StepContext.() -> Unit) {
        stageName = name
        stepContext = StepContext()
        stepContext.apply(init)
    }

}

class StepContext {

    lateinit var taskContext: TaskContext

    fun steps(init: TaskContext.() -> Unit) {
        taskContext = TaskContext()
        taskContext.apply(init)
    }
}

class TaskContext(var echo: String = "")

