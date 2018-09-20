package io.github.binout.kotlin.jenkins

fun main(args: Array<String>) {
    val pipeline = JenkinsPipeline("localhost", listOf(Stage("Test", listOf(Echo("Hello World")))))
    pipeline.execute()


    val pipelineAsDsl =
            pipeline {
                agent = "localhost"
                stages {
                    stage("Test") {
                        steps {
                            echo = "Hello World"
                        }
                    }
                }
            }
    pipelineAsDsl.execute()

}